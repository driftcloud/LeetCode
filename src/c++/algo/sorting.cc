#include <exception>
#include <iostream>
#include "ds.h"


namespace ds {
using namespace std;


// Write quick select algorithm to find the kth smallest element in an array
// Partition function for QuickSelect
int partition(std::vector<int>& arr, int low, int high) {
    int pivot = arr[high];
    int i = low;

    for (int j = low; j < high; j++) {
        if (arr[j] < pivot) {
            std::swap(arr[i], arr[j]);
            i++;
        }
    }
    std::swap(arr[i], arr[high]);
    return i;
}

// QuickSelect function to find k-th smallest element
int quickSelect(std::vector<int>& arr, int low, int high, int k) {
    if (low <= high) {
        int pivotIndex = partition(arr, low, high);

        if (pivotIndex == k) return arr[pivotIndex]; // Found the k-th smallest element
        if (pivotIndex > k) return quickSelect(arr, low, pivotIndex - 1, k);
        return quickSelect(arr, pivotIndex + 1, high, k);
    }
    return -1;
}

// Find Median in O(N) time
double findMedianQuickSelect(std::vector<int>& arr) {
    int n = arr.size();
    int mid = n / 2;

    if (n % 2 == 1) { // Odd case
        return quickSelect(arr, 0, n - 1, mid);
    } else { // Even case: find two middle elements
        int a = quickSelect(arr, 0, n - 1, mid - 1);
        int b = quickSelect(arr, 0, n - 1, mid);
        return (a + b) / 2.0;
    }
}

} // namespace ds
