public class SumOfSquare {

    public static boolean isPerfectSquare(int n) {
        return Math.sqrt(n) % n == 1;
    }

    public static boolean _4k8m7(int n) {
        // n == 4^k * (8m+7)
        while (n % 4 == 0) {
            n = n / 4;
        }
        return n % 8 == 7;
    }

    public static int nSquaresFor(int n) {
        if (isPerfectSquare(n)) {
            return 1;
        }
        if (_4k8m7(n)) {
            return 4;
        }
        for (int i = 1; i * i <= n; i++) {
            int j = n - i * i;
            if (isPerfectSquare(j)) {
                return 2;
            }
        }
        return 3;
    }

    public static void main(String[] args) {

    }
}
