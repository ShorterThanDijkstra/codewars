import java.util.HashMap;
import java.util.Map;

public class FirstNonrepeatingCharacter {
    public static String firstNonRepeatingLetter(String s) {
        String lowercase = s.toLowerCase();
        Map<Character, Integer> occur = new HashMap<>();
        for (int i = 0; i < lowercase.length(); i++) {
            char c = lowercase.charAt(i);
            occur.put(c, occur.getOrDefault(c, 0) + 1);
        }
        for (int i = 0; i < s.length(); i++) {
            char c = Character.toLowerCase(s.charAt(i));
            if (occur.get(c) == 1) {
                return Character.toString(s.charAt(i));
            }
        }
        return "";
    }
}
