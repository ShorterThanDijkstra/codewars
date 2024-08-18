import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TopWords {

    public static List<String> top3(String s) {
        Map<String, Integer> counts = new HashMap<>();
        int idx = 0;
        s = s.trim().toLowerCase();
        while (idx < s.length()) {
            int[] indices = word(s, idx);
            int start = indices[0];
            int end = indices[1];
            String word = s.substring(start, end);
            if (!"".equals(word.trim()) && !allApostrophes(word)) {
                counts.put(word, counts.getOrDefault(word, 0) + 1);
            }
            idx = end;
        }
        String[] top3Words = new String[]{"", "", ""};
        int[] top3Counts = new int[]{0, 0, 0};
        for (String word : counts.keySet()) {
            Integer count = counts.get(word);
            for (int i = 0; i < 3; i++) {
                if (count > top3Counts[i] || (count == top3Counts[i] && word.compareTo(top3Words[i]) < 0)) {
                    reRange(top3Words, top3Counts, i, word, count);
                    break;
                }
            }
        }
        List<String> words = new ArrayList<>();
        for (String word : top3Words) {
            if ("".equals(word)) {
                break;
            }

            words.add(word);
        }
        return words;
    }

    private static void reRange(String[] top3Words, int[] top3Counts, int idx, String newWord, int newCount) {
        for (int i = 2; i > idx; i--) {
            top3Words[i] = top3Words[i - 1];
            top3Counts[i] = top3Counts[i - 1];
        }
        top3Words[idx] = newWord;
        top3Counts[idx] = newCount;
    }

    private static boolean allApostrophes(String word) {
        for (int i = 0; i < word.length(); i++) {
            if (word.charAt(i) != '\'') {
                return false;
            }
        }
        return true;
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
        System.out.println(top3("'a 'A 'a' a'A' a'a'!"));
    }
}
