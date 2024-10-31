import java.util.ArrayList;
import java.util.List;

public class HammingNumbers {
   public static long hamming(int n) {
        List<Long> hamms = new ArrayList<>();
        hamms.add(1L);
        int i2 = 0;
        int i3 = 0;
        int i5 = 0;
        int i = 0;
        while (i < n) {
            long min = Math.min(hamms.get(i2) * 2, Math.min(hamms.get(i3) * 3, hamms.get(i5) * 5));
            hamms.add(min);
            i += 1;
            if (min % 2 == 0) {
                i2 += 1;
            }
            if (min % 3 == 0) {
                i3 += 1;
            }
            if (min % 5 == 0) {
                i5 += 1;
            }
        }
        return hamms.get(n - 1);
    }
  public static void main(String[] args) {
     for(int i = 1; i < 1000; i += 1) {
        System.out.println(hamming(i));
     }    
  }

}
