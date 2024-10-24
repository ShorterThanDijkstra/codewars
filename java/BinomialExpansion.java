// https://www.codewars.com/kata/541d0fdd3b6532e5c3000b5b/train/java
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
        if (s.charAt(end) == '+' || s.charAt(end) == '-') {
            end += 1;
        }
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
            if ("-".equals(s)) {
                a = -1;
            } else {
                a = Integer.parseInt(s);
            }
        }

        start = parseSpace(end, expr);
        end = parseVar(start, expr);
        String x = "";
        if (start != end) {
            x = expr.substring(start, end);
        }

        int b = 0;
        start = parseSpace(end, expr);
        end = parseNumber(start, expr);
        if (start != end) {
            String s = expr.substring(start, end);
            b = Integer.parseInt(s);
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

    private static long binomialCoefficient(int m, int n) {
        if (n == 0) {
            return 1;
        }
        long num = 1;
        long nTem = n;
        for (long i = m; i > (m - n); i--) {
            if (i % nTem == 0) {
                num = num * (i / nTem);
                nTem -= 1;
            } else {
                num = num * i;
            }
        }
        for (long i = 2; i <= nTem; i++) {
            num = num / i;
        }
        return num;
    }

    private static long powMod(int a, int n) {
        if (n == 0) {
            return 1L;
        }
        if (n == 1L) {
            return a;
        }
        if ((n & 1) == 1) {
            return a * powMod(a, n - 1);
        }
        long res = powMod(a, n / 2);
        return res * res;
    }

    private static String expand(Formula formula) {
        if (formula.m == 0) {
            return "1";
        }
        if (formula.a == 0) {
            return String.format("%d", powMod(formula.b, formula.m));
        }
        if (formula.b == 0) {
            return String.format("%d%s^%d", powMod(formula.a, formula.m), formula.x, formula.m);
        }
        StringBuilder builder = new StringBuilder();
        long aExpand = powMod(formula.a, formula.m);
        long bExpand = 1;
        long coeff = binomialCoefficient(formula.m, 0);
        builder.append(term2Str(coeff, aExpand, bExpand, formula.m, formula.m, formula.x));

        for (int i = formula.m - 1; i >= 0; i--) {
            coeff = binomialCoefficient(formula.m, i);
            aExpand = aExpand / formula.a;
            bExpand = bExpand * formula.b;
            builder.append(term2Str(coeff, aExpand, bExpand, i, formula.m, formula.x));
        }
        return builder.toString();
    }

    private static String term2Str(long coeff, long aExpand, long bExpand, int i, int m, String x) {
        long a = coeff * aExpand * bExpand;
        String res = String.format("%d%s^%d", a, x, i);
        if (i == 0) {
            res = String.format("%d", a);
        } else if (i == 1) {
            if (a == -1) {
                res = String.format("-%s", x);
            } else if (a == 1) {
                res = x;
            } else {
                res = String.format("%d%s", a, x);
            }
        } else {
            if (a == -1) {
                res = String.format("-%s^%d", x, i);
            } else if (a == 1) {
                res = String.format("%s^%d", x, i);
            }
        }

        String sign = "+";
        if (a < 0) {
            sign = "";
        }
        if (i == m && "+".equals(sign)) {
            sign = "";
        }
        return sign + res;
    }

    public static String expand(String expr) {
        Formula formula = parse(expr);
        return expand(formula);
    }

    public static void main(String[] args) {
        String expand = expand("(-m+3)^5");
        System.out.println(expand);

    }

}

