package interview.collections;

import java.util.Arrays;
import java.util.stream.IntStream;

public class PythagoreanTripples {

    public static final int LIMIT = 100000;

    static void main() {
        pythagoreanTripplesStream(LIMIT);
        pythagoreanTripplesImperative(LIMIT);
    }

    static void pythagoreanTripplesStream(int limit) {
        System.out.println("1. Calculating Pythagorean tripples using StreamAPI up to limit: " + limit);
        long start = System.currentTimeMillis();
        IntStream.rangeClosed(1, limit)
                .boxed()
                .flatMap(a -> IntStream.rangeClosed(a, limit)
                        .filter(b -> Math.sqrt(a * a + b * b) % 1 == 0)
                        .mapToObj(b -> new int[]{a, b, (int) Math.sqrt(a * a + b * b)})
                ).map(Arrays::toString)
                .count();
        //.forEach(System.out::println);
        System.out.println("1. " + limit + " calculations done in: " + (System.currentTimeMillis() - start) + " ms");
    }

    static void pythagoreanTripplesImperative(int limit) {
        System.out.println("2. Calculating Pythagorean tripples Imperatively up to limit: " + limit);
        long start = System.nanoTime();
        for (int m = 2; m <= Math.sqrt(limit); m++) {
            for (int n = 1; n < m; n++) {
                int a = m * m - n * n;
                int b = 2 * m * n;
                int c = m * m + n * n;

                if (c <= limit) {
                    //System.out.printf("%d, %d, %d%n", a, b, c);
                }
            }
        }
        System.out.println("2. " + limit + " calculations done in: " + (System.nanoTime() - start) / 1000000.0+ " ms");
    }
}
