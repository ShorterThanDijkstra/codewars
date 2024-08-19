// https://www.codewars.com/kata/52b7ed099cdc285c300001cd/train/java
import java.util.*;
public class SumIntervals {

   public static int sumIntervals(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(i -> i[0]));
        int sum = 0;
        int i = 0;
        while (i < intervals.length) {
            int start = i;
            int end = i + 1;
            int max = intervals[start][1];
            while (end < intervals.length && max >= intervals[end][0]) {
                if (max < intervals[end][1]) {
                    max = intervals[end][1];
                }
                end += 1;
            }
            sum += max - intervals[start][0];
            i = end;
        }
        return sum;
    }
      public static void main(String[] args) {
        int[][] intervals = {{30, 31}, {205, 213}, {-107, -104}, {406, 419}, {89, 93}, {325, 330}, {414, 428}, {10, 14}, {-9, -3}, {486, 495}, {432, 450}, {-21, -7}, {116, 132}, {-30, -20}, {-269, -267}, {-112, -96}, {460, 473}, {119, 126}};
        System.out.println(sumIntervals(intervals));
    }
}
