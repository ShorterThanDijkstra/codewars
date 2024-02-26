public class BefungeInterpreter { 
   public static String interpret(String code) {
        String[] split = code.split("\n");
        int width = 1000;
        int length = 1000;
        char[][] pane = new char[length][width];
        for (int i = 0; i < length; i++) {
            pane[i] = new char[width];
            Arrays.fill(pane[i], ' ');
            if (i < split.length) {
                String row = split[i];
                for (int j = 0; j < row.length(); j++) {
                    pane[i][j] = row.charAt(j);
                }
            }
        }


        StringBuilder output = new StringBuilder();
        Deque<Integer> stack = new ArrayDeque<>();

        int row = 0;
        int col = 0;
        int rowDir = 0;
        int colDir = 1;

        char c = pane[row][col];
        while (c != '@') {
            if (c <= '9' && c >= '0') {
                stack.push(c - '0');
            } else if (c == '+') {
                assert stack.size() >= 2;
                Integer pop1 = stack.pop();
                Integer pop2 = stack.pop();
                stack.push(pop1 + pop2);
            } else if (c == '-') {
                assert stack.size() >= 2;
                Integer pop1 = stack.pop();
                Integer pop2 = stack.pop();
                stack.push(pop2 - pop1);
            } else if (c == '*') {
                assert stack.size() >= 2;
                Integer pop1 = stack.pop();
                Integer pop2 = stack.pop();
                stack.push(pop2 * pop1);
            } else if (c == '/') {
                assert stack.size() >= 2;
                Integer pop1 = stack.pop();
                Integer pop2 = stack.pop();
                if (pop1 == 0) {
                    stack.push(0);
                } else {
                    stack.push(pop2 / pop1);
                }
            } else if (c == '%') {
                assert stack.size() >= 2;
                Integer pop1 = stack.pop();
                Integer pop2 = stack.pop();
                if (pop1 == 0) {
                    stack.push(0);
                } else {
                    stack.push(pop2 % pop1);
                }
            } else if (c == '!') {
                assert stack.size() >= 1;
                Integer pop = stack.pop();
                if (pop == 0) {
                    stack.push(1);
                } else {
                    stack.push(0);
                }
            } else if (c == '`') {
                assert stack.size() >= 2;
                Integer pop1 = stack.pop();
                Integer pop2 = stack.pop();
                if (pop2 > pop1) {
                    stack.push(1);
                } else {
                    stack.push(0);
                }
            } else if (c == '>') {
                rowDir = 0;
                colDir = 1;
            } else if (c == '<') {
                rowDir = 0;
                colDir = -1;
            } else if (c == '^') {
                rowDir = -1;
                colDir = 0;
            } else if (c == 'v') {
                rowDir = 1;
                colDir = 0;
            } else if (c == '?') {
                int rand = (int) (Math.random() * 4);
                if (rand < 2) {
                    rowDir = 0;
                    if (rand == 0) {
                        colDir = 1;
                    } else {
                        colDir = -1;
                    }
                } else {
                    colDir = 0;
                    if (rand == 2) {
                        rowDir = 1;
                    } else {
                        rowDir = -1;
                    }
                }
            } else if (c == '_') {
                assert stack.size() >= 1;
                Integer pop = stack.pop();
                rowDir = 0;
                if (pop == 0) {
                    colDir = 1;
                } else {
                    colDir = -1;
                }
            } else if (c == '|') {
                assert stack.size() >= 1;
                Integer pop = stack.pop();
                colDir = 0;
                if (pop == 0) {
                    rowDir = 1;
                } else {
                    rowDir = -1;
                }
            } else if (c == '"') {
                row = (row + rowDir) % length;
                col = (col + colDir) % width;
                c = pane[row][col];
                while (c != '"') {
                    stack.push((int) c);
                    row = (row + rowDir) % length;
                    col = (col + colDir) % width;
                    c = pane[row][col];
                }
            } else if (c == ':') {
                if (stack.size() == 0) {
                    stack.push(0);
                } else {
                    stack.push(stack.peek());
                }
            } else if (c == '\\') {
                assert stack.size() >= 1;
                Integer pop1 = stack.pop();
                if (stack.size() == 0) {
                    stack.push(0);
                    stack.push(pop1);
                } else {
                    Integer pop2 = stack.pop();
                    stack.push(pop1);
                    stack.push(pop2);
                }
            } else if (c == '$') {
                assert stack.size() >= 1;
                stack.pop();
            } else if (c == '.') {
                assert stack.size() >= 1;
                int pop = stack.pop();
                output.append(pop);
            } else if (c == ',') {
                assert stack.size() >= 1;
                Integer pop = stack.pop();
                char ascii = (char) pop.intValue();
                output.append(ascii);
            } else if (c == '#') {
                row = (row + rowDir) % length;
                col = (col + colDir) % width;
            } else if (c == 'p') {
                assert stack.size() >= 3;
                int y = stack.pop();
                int x = stack.pop();
                Integer v = stack.pop();
                assert x >= 0 && y >= 0;
                assert x <= length &&
                        y <= width;
                pane[x][y] = (char) v.intValue();
            } else if (c == 'g') {
                assert stack.size() >= 2;
                int y = stack.pop();
                int x = stack.pop();
                assert x >= 0 && y >= 0;
                assert x <= length &&
                        y <= width;
                stack.push((int) (pane[x][y]));

            } else if (c == ' ') {
                // do nothing
            } else {
                throw new RuntimeException("unknown instruction: " + c);
            }

            row = (row + rowDir) % length;
            col = (col + colDir) % width;
            c = pane[row][col];
        }
        return output.toString();
    }

    public static void main(String[] args) {
        System.out.println(interpret("01->1# +# :# 0# g# ,# :# 5# 8# *# 4# +# -# _@"));
    }
}
