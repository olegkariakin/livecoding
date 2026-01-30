package streams;

import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Dividors {
    static void main() {
        calc(15);
        var result = calcStatistics(15);
        System.out.println("Statistics. Count: " + result.getCount() + " Sum: " + result.getSum());
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

    static IntSummaryStatistics calcStatistics(int max) {
        return IntStream.rangeClosed(2, max)
                .filter(i -> i % 2 == 0 || i % 7 == 0)
                .summaryStatistics();
    }

}
