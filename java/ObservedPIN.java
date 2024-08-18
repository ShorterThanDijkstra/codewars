//import com.google.common.collect.ImmutableList;
//import java.util.*;
//public class ObservedPIN {
//     public static List<String> getPINs(String observed) {
//        List<List<Character>> adjacents = ImmutableList.of(
//                ImmutableList.of('0', '8'),
//                ImmutableList.of('1', '2', '4'),
//                ImmutableList.of('2', '1', '3', '5'),
//                ImmutableList.of('3', '2', '6'),
//                ImmutableList.of('4', '1', '5', '7'),
//                ImmutableList.of('5', '2', '4', '6', '8'),
//                ImmutableList.of('6', '3', '5', '9'),
//                ImmutableList.of('7', '4', '8'),
//                ImmutableList.of('8', '5', '7', '9', '0'),
//                ImmutableList.of('9', '6', '8')
//        );
//        List<String> res = new ArrayList<>();
//        StringBuilder builder = new StringBuilder();
//        getPINs(res, adjacents, builder, observed, 0);
//        return res;
//    }
//
//    private static void getPINs(List<String> res, List<List<Character>> adjacents, StringBuilder builder, String observed, int i) {
//        if (i == observed.length()) {
//            res.add(builder.toString());
//            return;
//        }
//        int digit = observed.charAt(i) - '0';
//        List<Character> adjacent = adjacents.get(digit);
//        for (Character character : adjacent) {
//            int length = builder.length();
//            builder.append(character);
//            getPINs(res, adjacents, builder, observed, i + 1);
//            builder.setLength(length);
//        }
//    }
//    public static void main(String[] args) {
//
//    }
//}
