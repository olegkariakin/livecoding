package streams;

import java.util.IntSummaryStatistics;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Dividors {
    static void main() {
        var result = calcCombined(150);

        result.forEach((key, stats) ->
                System.out.printf("%s: Кол-во=%d, Сумма=%d, Среднее=%.2f%n",
                        key, stats.getCount(), stats.getSum(), stats.getAverage()));
    }

    static Map<String, IntSummaryStatistics> calcCombined(int max) {
        return IntStream
                .rangeClosed(2, max)
                .filter(i -> i % 2 == 0 || i % 7 == 0)
                .boxed()
                .collect(Collectors.groupingBy(
                        i -> (i % 2 == 0) ? "Делится на 2" : "Делится на 7",
                        Collectors.summarizingInt(Integer::intValue)
                ));
    }
}
