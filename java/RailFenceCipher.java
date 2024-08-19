// https://www.codewars.com/kata/58c5577d61aefcf3ff000081/train/java
public class RailFenceCipher { 
     static String decode(String s, int n) {
        int i = 0;
        int width = n * (n - 1) / 2;
        int gap = width + 3;
        char[] res = new char[s.length()];
        for (int j = 0; j < n; j++) {
            gap -= 2;
            for (int k = j; k < res.length; k += gap) {
                res[k] = s.charAt(i);
                i += 1;
            }
            if (gap == 2) {
                gap = width + 3;
            }
        }
        return new String(res);
    }

    static String encode(String s, int n) {
        StringBuilder builder = new StringBuilder();
        int width = 2 * n;
        int gap = width;
        for (int i = 0; i < n; i++) {
            gap -= 2;
            for (int j = i; j < s.length(); j += gap) {
                builder.append(s.charAt(j));
            }
            if (gap == 2) {
                gap = width;
            }
        }
        return builder.toString();
    }
    /*
     * H       _     !
     *  e     , w   d
     *   l  o    o l
     *    l       r
     *
     */
    public static void main(String[] args) {
        String src = "Hello, World!";
        String tgt = "H !e,Wdloollr";
        String encoded = encode(src, 4);
        assert tgt.equals(encoded);

        String decoded = decode(tgt, 4);
        assert src.equals(decoded);
    }
}
