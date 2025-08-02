package streams;

import java.util.Arrays;
import java.util.List;

public class Numbers {

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        System.out.println("Initial numbers: " + list);

        //Calculate sumEven of even numbers in the stream
        int sumEven = list.stream()
                .filter(d -> d % 2 == 0)
                .mapToInt(Integer::intValue)
                .sum();

        System.out.println("Sum of even number: " + sumEven);

        // Calculate sum of odd numbers
        int sumOdd = list.stream()
                .filter(d -> d % 2 != 0)
                .mapToInt(Integer::intValue)
                .sum();
        System.out.println("Sum of odd number: " + sumOdd);
    }

}
