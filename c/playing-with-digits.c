#include <math.h>

int digPow(int n, int p) {
    int n_hat = n;
    int len = 0;
    while (n_hat > 0) {
        n_hat = n_hat / 10;
        len += 1;
    }

    int res = 0;
    n_hat = n;
    for (int p_hat = p + len - 1; p_hat >= p; p_hat--) {
        int bit = n_hat % 10;
        res += (int) pow((double) bit, (double) p_hat);
        n_hat = n_hat / 10;
    }
    if (res % n == 0) {
        return res / n;
    } else {
        return -1;
    }
}

int main() {

}