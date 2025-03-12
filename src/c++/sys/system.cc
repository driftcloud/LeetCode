#include <iostream>
#include <queue>
#include <thread>
#include <mutex>
#include <condition_variable>
#include <vector>
#include <chrono>

// Read-Write Lock (Multiple readers, single writer)

class RWLock {
private:
    std::mutex mtx;  // Mutex for synchronization
    std::condition_variable cv;  // Condition variable for readers & writers
    int readers = 0;  // Number of active readers
    bool writerActive = false;  // Is a writer active?

public:
    // Acquire read lock (shared access)
    void lockRead() {
        std::unique_lock<std::mutex> lock(mtx);
        cv.wait(lock, [this]() { return !writerActive; });  // Wait if writer is active
        readers++;
    }

    // Release read lock
    void unlockRead() {
        std::unique_lock<std::mutex> lock(mtx);
        readers--;
        if (readers == 0) {
            cv.notify_one();  // Notify waiting writers
        }
    }

    // Acquire write lock (exclusive access)
    void lockWrite() {
        std::unique_lock<std::mutex> lock(mtx);
        cv.wait(lock, [this]() { return !writerActive && readers == 0; });  // Wait if readers/writers active
        writerActive = true;
    }

    // Release write lock
    void unlockWrite() {
        std::unique_lock<std::mutex> lock(mtx);
        writerActive = false;
        cv.notify_all();  // Notify waiting readers and writers
    }
};


// Implement multiple producer, multiple consumer queue
class MPMCQueue {
private:
    std::queue<int> queue;
    std::mutex mtx;
    std::condition_variable cv;
    bool stop = false;
    const size_t maxSize;

public:
    explicit MPMCQueue(size_t capacity) : maxSize(capacity) {}

    // Producer: Push items into the queue
    void produce(int value) {
        std::unique_lock<std::mutex> lock(mtx);
        cv.wait(lock, [this]() { return queue.size() < maxSize || stop; });

        if (stop) return;

        queue.push(value);
        std::cout << "Produced: " << value << "\n";
        cv.notify_all();  // Notify consumers
    }

    // Consumer: Pop items from the queue
    void consume(int id) {
        while (true) {
            std::unique_lock<std::mutex> lock(mtx);
            cv.wait(lock, [this]() { return !queue.empty() || stop; });

            if (stop && queue.empty()) return;

            int value = queue.front();
            queue.pop();
            std::cout << "Consumer " << id << " consumed: " << value << "\n";

            cv.notify_all();  // Notify producers
        }
    }

    // Stop all processing
    void stopProcessing() {
        std::lock_guard<std::mutex> lock(mtx);
        stop = true;
        cv.notify_all();
    }
};

int MPMCQueue_main() {
    MPMCQueue queue(10);

    // Start multiple producer threads
    std::vector<std::thread> producers;
    for (int i = 0; i < 3; ++i) {
        producers.emplace_back([&queue, i]() {
            for (int j = 0; j < 10; ++j) {
                queue.produce(i * 10 + j);
                std::this_thread::sleep_for(std::chrono::milliseconds(100));
            }
        });
    }

    // Start multiple consumer threads
    std::vector<std::thread> consumers;
    for (int i = 0; i < 3; ++i) {
        consumers.emplace_back([&queue, i]() {
            queue.consume(i);
        });
    }

    // Join all producer threads
    for (auto& p : producers) p.join();

    // Stop queue processing after producers finish
    queue.stopProcessing();

    // Join all consumer threads
    for (auto& c : consumers) c.join();

    return 0;
}

// Implement a thread pool
class ThreadPool {
private:
    std::vector<std::thread> workers;
    std::queue<std::function<void()>> tasks;
    std::mutex mtx;
    std::condition_variable cv;
    bool stop;

public:
    explicit ThreadPool(size_t numThreads) : stop(false) {
        for (size_t i = 0; i < numThreads; ++i) {
            workers.emplace_back([this] {
                while (true) {
                    std::function<void()> task;
                    {
                        std::unique_lock<std::mutex> lock(mtx);
                        cv.wait(lock, [this] { return stop || !tasks.empty(); });

                        if (stop && tasks.empty()) return; // Exit thread if pool is stopped

                        task = std::move(tasks.front());
                        tasks.pop();
                    }
                    task(); // Execute task
                }
            });
        }
    }

    // Add a new task to the pool
    void enqueue(std::function<void()> task) {
        {
            std::lock_guard<std::mutex> lock(mtx);
            tasks.push(std::move(task));
        }
        cv.notify_one(); // Notify a worker thread
    }

    // Destructor to clean up threads
    ~ThreadPool() {
        {
            std::lock_guard<std::mutex> lock(mtx);
            stop = true;
        }
        cv.notify_all(); // Wake up all threads

        for (std::thread &worker : workers) {
            if (worker.joinable()) {
                worker.join(); // Wait for threads to finish
            }
        }
    }
};

int Threadpool_main() {
    ThreadPool pool(4); // Create a pool with 4 threads

    for (int i = 0; i < 10; ++i) {
        pool.enqueue([i] {
            std::cout << "Task " << i << " executed by thread " << std::this_thread::get_id() << "\n";
            std::this_thread::sleep_for(std::chrono::milliseconds(100));
        });
    }

    std::this_thread::sleep_for(std::chrono::seconds(2)); // Allow tasks to complete
    return 0;
}