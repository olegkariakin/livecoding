package streams;

import java.util.List;

public class MinMax {

    public static void main(String[] args) {
        var numbers = List.of(1, 2, 3, 4, 5, 6, 7, 8, 900, 10);
        System.out.println("Numbers: " + numbers);

        var max = numbers.stream()
                .max(Integer::compareTo).orElse(Integer.MIN_VALUE);
        System.out.println("Max: " + max);
    }
}
