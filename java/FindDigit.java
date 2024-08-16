// https://www.codewars.com/kata/59f6e1af3640ce12510000ad/train/java
public class FindDigit { 
    private static int[] top(int n) {
        int base = 1;
        double bitsCount = 0;
        double num = 0;
        while (bitsCount <= n) {
            bitsCount += 9 * Math.pow(10, base - 1) * base;
            num += 9 * Math.pow(10, base - 1);
            base += 1;
        }
        base -= 1;
        while (bitsCount - base > n) {
            bitsCount -= base;
            num -= 1;
        }
        return new int[]{(int) num, (int) (bitsCount - base)};
    }
    public static void main(String[] args) {

    }
}
