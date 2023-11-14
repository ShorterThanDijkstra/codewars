#include <stdio.h>
#include <stdlib.h>

int mul(int **a, int **b, int n, size_t row, size_t col) {
    int res = 0;
    for (size_t i = 0; i < n; i++) {
        res += a[row][i] * b[i][col];
    }
    return res;
}

int **matrix_multiplication(int **a, int **b, int n) {
    // TODO: Return the result of A × B in the form of an n × n matrix
    // NOTE: Please use dynamic memory allocation to construct your
    // matrix as the test cases will `free` the memory from your
    // returned result afterwards
    int **res = (int **) malloc(n * sizeof(int *));
    for (size_t r = 0; r < n; r++) {
        res[r] = (int *) malloc(n * sizeof(int));
    }
    for (size_t i = 0; i < n; i++) {
        for (size_t j = 0; j < n; j++) {
            res[i][j] = mul(a, b, n, i, j);
        }
    }
    return res;
}
//
//int main() {
//    int n = 2;
//    int **a = (int **) malloc(n * sizeof(int *));
//    for (size_t r = 0; r < n; r++) {
//        a[r] = (int *) malloc(n * sizeof(int));
//    }
//
//    int **b = (int **) malloc(n * sizeof(int *));
//    for (size_t r = 0; r < n; r++) {
//        b[r] = (int *) malloc(n * sizeof(int));
//    }
//
//    **a = 1;
//    *(*a + 1) = 2;
//    **(a + 1) = 3;
//    *(*(a + 1) + 1) = 2;
//
//    **b = 3;
//    *(*b + 1) = 2;
//    **(b + 1) = 1;
//    *(*(b + 1) + 1) = 1;
//
//    int **res = matrix_multiplication(a, b, 2);
//
//    return 0;
//}