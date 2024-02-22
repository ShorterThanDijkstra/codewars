public class BefungeInterpreter { 
	  public static String interpret(String code) {
        String[] split = code.split("\n");
        char[][] pane = new char[split.length][];
        for (int i = 0; i < split.length; i++) {
            pane[i] = split[i].toCharArray();
        }
        int width = pane[0].length;
        for (int i = 1; i < pane.length; i++) {
            width = Math.max(width, pane[i].length);
        }
        int length = pane.length;
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
                stack.push(pop2 + pop1);
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
                if (stack.size() == 1) {
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
                assert x <= width && x >= 0;
                assert y <= length && y >= 0;
                pane[x][y] = (char) v.intValue();
            } else if (c == 'g') {
                assert stack.size() >= 2;
                int y = stack.pop();
                int x = stack.pop();
                stack.push(pane[x][y] + '0');
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
        System.out.println(interpret(
                  "08>:1-:v v *_$.@ \n" +
                        "  ^    _$>\\:^  ^    _$>\\:^"));
    }
}
