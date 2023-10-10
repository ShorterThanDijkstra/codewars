//  return a dynamically allocated `long long` array of results

#include <stdlib.h>
#include <stdio.h>

long long *tribonacci(const long long signature[3], size_t n) {
    if (n == 0) {
        return NULL;
    }
    long long *res = (long long *) malloc(n * sizeof(long long));
    res[0] = signature[0];
    res[1] = signature[1];
    res[2] = signature[2];

    for (size_t i = 3; i < n; ++i) {
        res[i] = res[i - 1] + res[i - 2] + res[i - 3];
    }
    return res;
}
//
//int main() {
//    size_t n = 10;
//    const long long sig[] = {1, 1, 1};
//    long long *res = tribonacci(sig, n);
//    for (size_t i = 0; i < n; ++i) {
//        printf("%lld ", res[i]);
//    }
//}