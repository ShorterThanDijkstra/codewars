public class Top3 { 

    public static List<String> top3(String s) {
        Map<String, Integer> counts = new HashMap<>();
        int idx = 0;
        while (idx < s.length()) {
            int[] indices = word(s, idx);
            String word = s.substring(indices[0], indices[1]);
            counts.put(word, counts.getOrDefault(word, 0) + 1);
            idx = indices[1];
        }
        String[] top3Words = new String[]{"", "", ""};
        int[] top3Counts = new int[]{0, 0, 0};
        for (String word : counts.keySet()) {
            Integer count = counts.get(word);
            for (int i = 0; i < 3; i++) {
                if (count >= top3Counts[i]) {
                    reRange(top3Words, top3Counts, i, word, count);
                    break;
                }
            }
        }
        List<String > res = new ArrayList<>();
        for (String word:top3Words) {
            if ("".equals(word)) {
                break;
            }
            res.add(word);
        }
        return res;
    }

    private static void reRange(String[] top3Words, int[] top3Counts, int idx, String newWord, int newCount) {
        for (int i = 2; i > idx; i--) {
            top3Words[i] = top3Words[i - 1];
            top3Counts[i] = top3Counts[i - 1];
        }
        top3Words[idx] = newWord;
        top3Counts[idx] = newCount;
    }

    private static int[] word(String s, int idx) {
        int start = idx;
        while (start < s.length() && !validChar(s.charAt(start))) {
            start += 1;
        }
        int end = start;
        while (end < s.length() && validChar(s.charAt(end))) {
            end += 1;
        }
        return new int[]{start, end};
    }

    private static boolean validChar(char c) {
        return (c <= 'z' && c >= 'a') || (c <= 'Z' && c >= 'A') || c == '\'';
    }

    public static void main(String[] args) {
        top3("  //wont won't won't");
    }
}
