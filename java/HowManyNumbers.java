// https://www.codewars.com/kata/5877e7d568909e5ff90017e6/solutions/java
import java.util.*;
class HowManyNumbers {
 public static List<Long> list(long... ls) {
        List<Long> res = new ArrayList<>();
        for (long l : ls) {
            res.add(l);
        }
        return res;
    }

 

    public static List<Long> findAll(final long p, final int s, final int n) {
        if (s == 0) {
            return list();
        }
        if (s < p) {
            return list();
        }
        if (n == 0) {
            return list();
        }
        if (n == 1) {
            if (s < 10) {
                return list(1, s, s);
            } else {
                return list();
            }
        }

        long num = 0;
        long min = -1;
        long max = -1;
        long base = (long) Math.pow(10, n - 1);
        for (int i = 1; i < s; i++) {
            if (i < p) {
                continue;
            }
            List<Long> find = findAll(i, s - i, n - 1);
            if (find.isEmpty()) {
                continue;
            }
            num += find.get(0);

            long min_ = i * base + find.get(1);
            long max_ = i * base + find.get(2);
            if (min == -1) {
                min = min_;
            } else {
                min = Math.min(min, min_);
            }
            if (max == -1) {
                max = max_;
            } else {
                max = Math.max(max, max_);
            }
        }
        if (num == 0) {
            return list();
        }
        return list(num, min, max);
    }

    public static List<Long> findAll(final int s, final int n) {
        return findAll(0, s, n);
    }

}
