//https://www.codewars.com/kata/56a1c63f3bc6827e13000006/train/java
import java.util.Arrays;
import java.util.Comparator;

record Value(int val, int idx) {
}

public class Smaller {

    public static int[] smaller(int[] unsorted) {
        Value[] vs = new Value[unsorted.length];
        for (int i = 0; i < unsorted.length; i++) {
            vs[i] = new Value(unsorted[i], i);
        }
        Arrays.sort(vs, Comparator.comparingInt(Value::val));

        int equalPre = 0;
        int[] res = new int[unsorted.length];
        for (int i = 0; i < unsorted.length; i++) {
            if (i != 0 && vs[i] == vs[i - 1]) {
                equalPre += 1;
            } else {
                equalPre = 0;
            }
            res[vs[i].idx()] = i - equalPre;
        }
        return res;
    }

    public static void main(String[] args) {
        int[] smaller = smaller(new int[]{1, 2, 0});
    }
}