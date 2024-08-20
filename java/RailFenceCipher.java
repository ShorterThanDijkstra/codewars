// https://www.codewars.com/kata/58c5577d61aefcf3ff000081/train/java
public class RailFenceCipher { 
   static String decode(String s, int n) {
        int width = 2 * n - 2;
        int gap = width;
        int sIdx = 0;
        char[] res = new char[s.length()];
        for (int i = 0; i < n; i++) {
            int j = i;
            while (j < res.length) {
                res[j] = s.charAt(sIdx);
                j += gap;
                gap = width - gap;
                if (gap == 0) {
                    gap = width;
                }
                sIdx += 1;
            }

            gap -= 2;
            if (gap == 0) {
                gap = width;
            }
        }
        return new String(res);
    }

    static String encode(String s, int n) {
        StringBuilder builder = new StringBuilder();
        int width = 2 * n - 2;
        int gap = width;
        for (int i = 0; i < n; i++) {
            int j = i;
            while (j < s.length()) {
                builder.append(s.charAt(j));
                j += gap;
                gap = width - gap;
                if (gap == 0) {
                    gap = width;
                }
            }
            gap -= 2;
            if (gap == 0) {
                gap = width;
            }
        }
        return builder.toString();
    }
}
