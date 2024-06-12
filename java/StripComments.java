public class StripComments { 
public static String stripComments(String text, String[] commentSymbols) {
        if (text == null || "".equals(text.trim())) {
            return "";
        }
        Arrays.sort(commentSymbols);
        StringBuilder builder = new StringBuilder();
        StringBuilder line = new StringBuilder();
        int i = 0;
        while (i < text.length()) {
            if (text.charAt(i) == '\n') {
                trim(line);
                builder.append(line);
                line.setLength(0);
                builder.append('\n');
                i += 1;
                continue;
            }
            if (commentStart(text, i, commentSymbols)) {
                trim(line);
                builder.append(line);
                line.setLength(0);
                while (i < text.length() && text.charAt(i) != '\n') {
                    i += 1;
                }
                if (i < text.length()) {
                    builder.append('\n');
                }
                i += 1;
                continue;
            }
            line.append(text.charAt(i));
            i += 1;
        }
        trim(line);
        if (line.length() > 0) {
            builder.append(line);
        }
        return builder.toString();
    }

    private static void trim(StringBuilder builder) {
        int len = builder.length() - 1;
        while (len >= 0 && Character.isWhitespace(builder.charAt(len))) {
            len -= 1;
        }
        builder.setLength(len + 1);
    }

    private static boolean commentStart(String text, int i, String[] commentSymbols) {
        for (String comment : commentSymbols) {
            if (text.startsWith(comment, i)) {
                return true;
            }
        }
        return false;
    }
    public static void main(String[] args) {

    }
}
