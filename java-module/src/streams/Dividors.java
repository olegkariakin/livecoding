package streams;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Dividors {
    static void main() {
        calc(15);
        List<Integer> result = calcStatistics(15);
        System.out.println("Statistics. Count: " + result.get(0) + " Sum: " + result.get(1));
    }

    static void calc(int max) {
        Map<String, List<Integer>> groups = IntStream.rangeClosed(2, max)
                .boxed()
                .filter(i -> i % 2 == 0 || i % 7 == 0)
                .collect(Collectors.groupingBy(i -> {
                    if (i % 2 == 0) return "Делится на 2";
                    return "Делится на 7";
                }));
        groups.forEach((key, list) -> System.out.println(STR."\{key}: \{list}"));
    }

    static List<Integer> calcStatistics(int max) {
        List<Integer> results = new ArrayList<>();

        int count = (int) IntStream.rangeClosed(2, max)
                .filter(i -> i % 2 == 0 || i % 7 == 0)
                .count();

        int sum = IntStream.rangeClosed(2, max)
                .filter(i -> i % 2 == 0 || i % 7 == 0)
                .sum();

        results.add(count);
        results.add(sum);

        return results;
    }

}
