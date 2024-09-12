// https://www.codewars.com/kata/54bd79a7956834e767001357
import java.util.*;
import java.lang.reflect.*;
import java.util.concurrent.atomic.AtomicLong;
public class Psychic {
  public static double guess() {
        long seed = getSeed().get();
        Random random = new Random();
        setSeed(random, seed);
        return random.nextDouble();
    }

    private static AtomicLong getSeed() {
        try {
            Class<?> math = Class.forName("java.lang.Math");
            Class<?> holder = Arrays.stream(math.getDeclaredClasses()).filter(it -> "RandomNumberGeneratorHolder".equals(it.getSimpleName())).findFirst().get();
            Field randomNumberGenerator = holder.getDeclaredField("randomNumberGenerator");
            randomNumberGenerator.setAccessible(true);
            Random r = (Random) randomNumberGenerator.get(null);
            Field seed = Random.class.getDeclaredField("seed");
            seed.setAccessible(true);
            return ((AtomicLong) seed.get(r));
        } catch (Exception e) {
            return new AtomicLong();
        }
    }

    private static void setSeed(Random random, long seed) {
        try {
            Field origin = Random.class.getDeclaredField("seed");
            origin.setAccessible(true);

            Field modifiersField = Field.class.getDeclaredField("modifiers");
            modifiersField.setAccessible(true);
            modifiersField.setInt(origin, origin.getModifiers() & ~java.lang.reflect.Modifier.FINAL);

            origin.set(random, new AtomicLong(seed));
        } catch (Exception e) {

        }

    }

}
