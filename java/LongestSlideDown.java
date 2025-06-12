// https://www.codewars.com/kata/551f23362ff852e2ab000037/java
public class LongestSlideDown {

   public static int max(int[] maxRow, int col) {
        int max = 0;
        if (col - 1 >= 0 && col - 1 < maxRow.length) {
            max = Math.max(maxRow[col - 1], max);
        }
        if (col >= 0 && col < maxRow.length) {
            max = Math.max(maxRow[col], max);
        }
//         if (col + 1 >= 0 && col + 1 < maxRow.length) {
//             max = Math.max(maxRow[col + 1], max);
//         }
        return max;
    }

    public static int longestSlideDown(int[][] pyramid) {
        int[] maxRow = new int[]{pyramid[0][0]};
        for (int row = 1; row < pyramid.length; row++) {
            int[] currRow = pyramid[row];
            int[] auxRow = new int[currRow.length];
            for (int col = 0; col < currRow.length; col++) {
                int val = currRow[col];
                int max = max(maxRow, col);
                auxRow[col] = max + val;
            }
            maxRow = auxRow;
        }

        int max = 0;
        for (int val : maxRow) {
            max = Math.max(max, val);
        }
        return max;
    }
}
