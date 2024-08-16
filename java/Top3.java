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
        String[] top3Words = new String[3];
        int[] top3Counts = new int[3];
        for (String word : counts.keySet()) {
            Integer count = counts.get(word);
            reRange(top3Words, top3Counts, 0, word, count);
        }
        return null;
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
        String s = "In a village of La Mancha, the name of which I have no desire to call to mind, there lived not long since one of those gentlemen that keep a lance in the lance-rack, an old buckler, a lean hack, and a greyhound for coursing. An olla of rather more beef than mutton, a salad on most  nights, scraps on Saturdays, lentils on Fridays, and a pigeon or so extra  on Sundays, made away with three-quarters of his income.";
        top3(s);
    }
}
