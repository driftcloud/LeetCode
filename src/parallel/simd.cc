#include <iostream>
#include <immintrin.h>  // AVX2 intrinsics

// simd matmul
void matmul_simd(float* A, float* B, float* C, int M, int N, int K) {
    for (int i = 0; i < M; i++) {          // Iterate over rows of A
        for (int j = 0; j < N; j++) {      // Iterate over columns of B
            __m256 sum = _mm256_setzero_ps();  // Initialize sum as zero

            for (int k = 0; k < K; k += 8) {  // Process 8 elements at a time
                // Load 8 elements from A and B
                __m256 a_vec = _mm256_loadu_ps(&A[i * K + k]);
                __m256 b_vec = _mm256_loadu_ps(&B[k * N + j]);

                // Multiply and accumulate
                sum = _mm256_fmadd_ps(a_vec, b_vec, sum);  // sum += A[i, k] * B[k, j]
            }

            // Store result (horizontal sum to scalar)
            float temp[8];
            _mm256_storeu_ps(temp, sum);
            C[i * N + j] = temp[0] + temp[1] + temp[2] + temp[3] + temp[4] + temp[5] + temp[6] + temp[7];
        }
    }
}

