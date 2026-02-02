package interview.streamapi;

import java.util.stream.IntStream;

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
        IntStream.iterate(2, n -> n+1)
                .filter(number -> number > 1 && IntStream.rangeClosed(2, (int) Math.sqrt(number))
                        .noneMatch(i -> number % i == 0))
                .limit(100)
                .forEach(System.out::println);
    }

}
