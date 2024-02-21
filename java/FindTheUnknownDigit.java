import java.util.*;

public class FindTheUnknownDigit {

    public static int parseNumber(final String expression, int index, List<Character> number) {
        if (index < expression.length() && expression.charAt(index) == '-') {
            number.add(expression.charAt(index));
            index += 1;
        }
        while (index < expression.length()) {
            char c = expression.charAt(index);
            if ((c <= '9' && c >= '0') || c == '?') {
                index += 1;
                number.add(c);
            } else {
                return index;
            }
        }
        return expression.length();
    }

    public static int solveExpression(final String expression) {

        int index = 0;
        List<Character> cs1 = new ArrayList<>();
        index = parseNumber(expression, index, cs1);

        char op = expression.charAt(index);
        index += 1;

        List<Character> cs2 = new ArrayList<>();
        index = parseNumber(expression, index, cs2);

        index += 1;
        List<Character> cs3 = new ArrayList<>();
        parseNumber(expression, index, cs3);

        return solve(op, cs1, cs2, cs3);
    }

    private static int[] toNumber(List<Character> cs) {
        int init = 0;
        int step = 0;
        for (char c : cs) {
            if (c <= '9' && c >= '0') {
                init *= 10;
                step *= 10;
                init += c - '0';
            } else if (c == '?') {
                init *= 10;
                step *= 10;
                step += 1;
            }
        }
        if (cs.get(0) == '-') {
            init = -init;
            step = -step;
        }
        return new int[]{init, step};
    }

    private static int solve(char op, List<Character> cs1, List<Character> cs2, List<Character> cs3) {

        int[] tuple = toNumber(cs1);
        int n1 = tuple[0];
        int step1 = tuple[1];

        tuple = toNumber(cs2);
        int n2 = tuple[0];
        int step2 = tuple[1];

        tuple = toNumber(cs3);
        int n3 = tuple[0];
        int step3 = tuple[1];

        int start = 0;
        Character question = '?';
        if (question.equals(cs1.get(0)) && cs1.size() > 1 ||
                question.equals(cs2.get(0)) && cs2.size() > 1 ||
                question.equals(cs3.get(0)) && cs3.size() > 1) {
            start = 1;
            n1 += step1;
            n2 += step2;
            n3 += step3;
        }

        while (start <= 9) {
            if (op == '+' && n1 + n2 == n3) {
                return start;
            }
            if (op == '-' && n1 - n2 == n3) {
                return start;
            }
            if (op == '*' && n1 * n2 == n3) {
                return start;
            }
            n1 += step1;
            n2 += step2;
            n3 += step3;
            start += 1;
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(solveExpression("19--45=5?"));
    }
   
}
