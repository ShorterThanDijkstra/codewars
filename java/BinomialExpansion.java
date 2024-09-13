// https://www.codewars.com/kata/540d0fdd3b6532e5c3000b5b/train/java
public class BinomialExpansion { 
    private static int parseVar(int start, String s) {
        int end = start;
        while (end < s.length() && Character.isLetter(s.charAt(end))) {
            end += 1;
        }
        return end;
    }

    private static int parseNumber(int start, String s) {
        int end = start;
        while (end < s.length() && Character.isDigit(s.charAt(end))) {
            end += 1;
        }
        return end;
    }

    private static int parseSpace(int start, String s) {
        int end = start;
        while (end < s.length() && s.charAt(end) == ' ') {
            end += 1;
        }
        return end;
    }

    private static int parseChar(char c, int start, String s) {
        if (start >= s.length()) {
            throw new IllegalArgumentException();
        }
        if (s.charAt(start) != c) {
            throw new IllegalArgumentException();
        }
        return start + 1;
    }

   public static String expand(String expr) {
        // (ax+b)^m
        int start = parseSpace(0, expr);
        start = parseChar('(', start, expr);

        start = parseSpace(start, expr);
        int end = parseNumber(start, expr);
        int a = 1;
        if (start != end) {
            String s = expr.substring(start, end);
            a = Integer.parseInt(s);
        }

        start = parseSpace(start, expr);
        end = parseVar(start, expr);
        String x = "";
        if (start != end) {
            x = expr.substring(start, end);
        }

        start = parseSpace(start, expr);
        boolean isPlus = true;
        if (expr.charAt(start) == '-') {
            isPlus = false;
        }


        return "";
    }

}
