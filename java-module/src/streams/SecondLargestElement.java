package streams;

import java.util.Arrays;
import java.util.List;

public class SecondLargestElement {

    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 3, - 40, 0, -40, 0, -6, 7, 8, 900, 10);
        System.out.println("Initial numbers: " + numbers);

        var secondSmallest = numbers.stream()
                .distinct()
                .sorted((a, b) -> Integer.compare(a, b))
                .skip(1)
                .findFirst()
                .orElse(null);
        System.out.println("Second largest: " + secondSmallest);

        var secondLargest = numbers.stream()
                .distinct()
                .sorted((a, b) -> Integer.compare(b, a))
                .skip(1)
                .findFirst()
                .orElse(Integer.MIN_VALUE);
        System.out.println("Second largest: " + secondLargest);

        var top3Elements = numbers.stream()
                .distinct()
                .sorted((a, b) -> Integer.compare(b, a))
                .limit(3)
                .toList();
        System.out.println("Top 3 elements: " + top3Elements);
    }

}
