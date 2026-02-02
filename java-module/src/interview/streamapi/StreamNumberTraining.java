package interview.streamapi;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamNumberTraining {

    static void main() {
        // 1. Сумма четных чисел пропустить первые 10 взять следующие 5 и взять сумму
        int sum = IntStream.iterate(0, n -> n + 1)
                .filter(n -> n % 2 == 0)
                .skip(10)
                .limit(5)
                .sum();
        System.out.println("1. Sum: " + sum);

        //2. Поиск простых чисел
        System.out.println("2. First 20 prime numbers");
        IntStream.iterate(2, n -> n + 1)
                .filter(number -> number > 1 && IntStream.rangeClosed(2, (int) Math.sqrt(number))
                        .noneMatch(i -> number % i == 0))
                .limit(10)
                .forEach(System.out::println);

        //3. Пифагоровы тройки
        System.out.println("3. Pythagorean triangles");
        Stream<int[]> pythagoreanTriples = IntStream.rangeClosed(1, 50)
                .boxed()
                .flatMap(a -> IntStream.rangeClosed(a, 50)
                        .filter(b -> Math.sqrt(a * a + b * b) % 1 == 0)
                        .mapToObj(b -> new int[]{a, b, (int) Math.sqrt(a * a + b * b)})
                );
        pythagoreanTriples
                .map(Arrays::toString)
                .forEach(System.out::println);

        //4. ZigZag stream
        String zigZagResult = IntStream.rangeClosed(1, 50)
                .filter(n -> n % 3 == 0 || n % 5 == 0)
                .peek(n -> System.out.println("After filter: " + n))
                .boxed()
                .sorted((a, b) -> {
                    boolean aIsEven = a % 2 == 0;
                    boolean bIsEven = b % 2 == 0;

                    if (aIsEven != bIsEven) {
                        return aIsEven ? 1 : -1;
                    }
                    return aIsEven ? b.compareTo(a) : a.compareTo(b);
                })
                .skip(3)
                .map(String::valueOf)
                .collect(Collectors.joining(", "));
        System.out.println("4. ZigZag result: " + zigZagResult);
    }

}
