#include <cuda_runtime.h>
#include <iostream>

#define TILE_WIDTH 16

__global__ void matrixMulKernel(float* d_A, float* d_B, float* d_C, int numARows, int numACols, int numBCols) {
    __shared__ float ds_A[TILE_WIDTH][TILE_WIDTH];
    __shared__ float ds_B[TILE_WIDTH][TILE_WIDTH];

    int bx = blockIdx.x;  int by = blockIdx.y;
    int tx = threadIdx.x; int ty = threadIdx.y;

    int Row = by * TILE_WIDTH + ty;
    int Col = bx * TILE_WIDTH + tx;

    float Cvalue = 0.0;

    for (int t = 0; t < (numACols - 1) / TILE_WIDTH + 1; ++t) {
        if (Row < numARows && t * TILE_WIDTH + tx < numACols)
            ds_A[ty][tx] = d_A[Row * numACols + t * TILE_WIDTH + tx];
        else
            ds_A[ty][tx] = 0.0;

        if (Col < numBCols && t * TILE_WIDTH + ty < numACols)
            ds_B[ty][tx] = d_B[(t * TILE_WIDTH + ty) * numBCols + Col];
        else
            ds_B[ty][tx] = 0.0;

        __syncthreads();

        #pragma unroll
        for (int i = 0; i < TILE_WIDTH; ++i)
            Cvalue += ds_A[ty][i] * ds_B[i][tx];

        __syncthreads();
    }

    if (Row < numARows && Col < numBCols)
        d_C[Row * numBCols + Col] = Cvalue;
}

void matrixMultiply(float* h_A, float* h_B, float* h_C, int numARows, int numACols, int numBCols) {
    float *d_A, *d_B, *d_C;
    size_t sizeA = numARows * numACols * sizeof(float);
    size_t sizeB = numACols * numBCols * sizeof(float);
    size_t sizeC = numARows * numBCols * sizeof(float);

    cudaMalloc(&d_A, sizeA);
    cudaMalloc(&d_B, sizeB);
    cudaMalloc(&d_C, sizeC);

    cudaMemcpy(d_A, h_A, sizeA, cudaMemcpyHostToDevice);
    cudaMemcpy(d_B, h_B, sizeB, cudaMemcpyHostToDevice);

    dim3 dimBlock(TILE_WIDTH, TILE_WIDTH);
    dim3 dimGrid((numBCols - 1) / TILE_WIDTH + 1, (numARows - 1) / TILE_WIDTH + 1);

    matrixMulKernel<<<dimGrid, dimBlock>>>(d_A, d_B, d_C, numARows, numACols, numBCols);

    cudaMemcpy(h_C, d_C, sizeC, cudaMemcpyDeviceToHost);

    cudaFree(d_A);
    cudaFree(d_B);
    cudaFree(d_C);
}

int main() {
    int numARows = 4, numACols = 4, numBCols = 4;
    float h_A[] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16};
    float h_B[] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16};
    float h_C[numARows * numBCols];

    matrixMultiply(h_A, h_B, h_C, numARows, numACols, numBCols);

    for (int i = 0; i < numARows; ++i) {
        for (int j = 0; j < numBCols; ++j) {
            std::cout << h_C[i * numBCols + j] << " ";
        }
        std::cout << std::endl;
    }

    return 0;
}

// You are given an array of floats of size N. Your task is to write a CUDA program to find the sum of all elements in this array.

#define BLOCK_SIZE 256

__global__ void sharedMemReduction(float *input, float *output, int N) {
    __shared__ float sharedData[BLOCK_SIZE];

    int tid = threadIdx.x;
    int globalIndex = threadIdx.x + blockIdx.x * blockDim.x;

    sharedData[tid] = (globalIndex < N) ? input[globalIndex] : 0.0f;
    __syncthreads();

    // Perform Reduction in Shared Memory
    for (int stride = BLOCK_SIZE / 2; stride > 0; stride /= 2) {
        if (tid < stride) {
            sharedData[tid] += sharedData[tid + stride];
        }
        __syncthreads();
    }

    // Write block result to global memory
    if (tid == 0) {
        output[blockIdx.x] = sharedData[0];
    }
}

void sumReduction(float *h_input, int N) {
    float *d_input, *d_output;
    int gridSize = (N + BLOCK_SIZE - 1) / BLOCK_SIZE;
    
    cudaMalloc(&d_input, N * sizeof(float));
    cudaMalloc(&d_output, gridSize * sizeof(float));

    cudaMemcpy(d_input, h_input, N * sizeof(float), cudaMemcpyHostToDevice);

    sharedMemReduction<<<gridSize, BLOCK_SIZE>>>(d_input, d_output, N);

    // Copy partial results back to host
    float *h_partialSums = new float[gridSize];
    cudaMemcpy(h_partialSums, d_output, gridSize * sizeof(float), cudaMemcpyDeviceToHost);

    // Final sum on CPU
    float totalSum = 0;
    for (int i = 0; i < gridSize; i++) {
        totalSum += h_partialSums[i];
    }

    std::cout << "Final Sum: " << totalSum << std::endl;

    delete[] h_partialSums;
    cudaFree(d_input);
    cudaFree(d_output);
}

