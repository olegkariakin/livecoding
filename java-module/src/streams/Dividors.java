package streams;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Dividors {
    static void main() {
        calc(15);
    }

    static void calc(int max) {
        Map<String, List<Integer>> groups = IntStream.rangeClosed(2, max)
                .boxed()
                .filter(i -> i % 2 == 0 || i % 7 == 0)
                .collect(Collectors.groupingBy(i -> {
                    if (i % 2 == 0) return "Делится на 2";
                    return "Делится на 7";
                }));
        groups.forEach((key, list) -> System.out.println(key + ": " + list));
    }

}
