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

    record Formula(int a, String x, int b, int m) {
    }

    private static Formula parse(String expr) {
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

        start = parseSpace(end, expr);
        int b = 0;
        if (expr.charAt(start) == '+') {
            start = parseSpace(start + 1, expr);
            end = parseNumber(start, expr);
            String s = expr.substring(start, end);
            b = Integer.parseInt(s);
        } else if (expr.charAt(start) == '-') {
            start = parseSpace(start + 1, expr);
            end = parseNumber(start, expr);
            String s = expr.substring(start, end);
            b = -Integer.parseInt(s);
        }

        start = parseSpace(end, expr);
        start = parseChar(')', start, expr);
        start = parseSpace(start, expr);
        start = parseChar('^', start, expr);
        start = parseSpace(start, expr);
        end = parseNumber(start, expr);
        String s = expr.substring(start, end);
        int m = Integer.parseInt(s);
        return new Formula(a, x, b, m);
    }

    private static int coefficient(int m, int n) {
        if (n == 0) {
            return 1;
        }
        int num = 1;
        int nTem = n;
        for (int i = m; i > (m - n); i--) {
            if (i % nTem == 0) {
                num = num * (i / nTem);
                nTem -= 1;
            } else {
                num = num * i;
            }
        }
        for (int i = 2; i <= nTem; i++) {
            num = num / i;
        }
        return num;
    }

    private static int powMod(int x, int y, int z) {
        int result = 1 % z;
        x %= z;
        while (y != 0) {
            if ((y & 1) == 1) {
                result = (result * x) % z;
            }
            x = (x * x) % z;
            y >>= 1;
        }
        return result;
    }

    private static String expand(Formula formula) {
        for (int i = 0; i <= formula.m; i++) {

        }
        return "";
    }

    public static String expand(String expr) {
        Formula formula = parse(expr);
        return expand(formula);
    }

    public static void   public static void main(String[] args) {
    
  }(String[] args) {
        String expand = expand("( x  -3 )^6");
        int coefficient = coefficient(6, 3);
    }

}

