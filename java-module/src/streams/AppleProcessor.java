package streams;

import java.util.ArrayList;
import java.util.List;
import java.util.function.IntPredicate;

public class AppleProcessor {

    public static <T> List<T> filterWithPredicate(List<T> list, Predicate<T> p) {
        List<T> results = new ArrayList<>();
        for (T t : list) {
            if (p.test(t)) {
                results.add(t);
            }
        }
        return results;
    }

    static void main() {
        IntPredicate evenNumbers = (int i) -> i % 2 == 0;
        System.out.println("1000 ?: " + evenNumbers.test(1000)); // No auto-boxing
        Predicate<Integer> oddNumbers = (Integer i) -> i % 2 != 0;
        System.out.println("1000 ?: " + oddNumbers.test(1000)); // With Auto-boxing
    }

    private static void filterWithPredicate() {
        List<String> listOfStrings = List.of("one", "two", "", "");
        Predicate<String> nonEmptyStringPredicate = (String s) -> !s.isEmpty();
        List<String> nonEmpty = filterWithPredicate(listOfStrings, nonEmptyStringPredicate);
        System.out.println(STR."Size: \{nonEmpty.size()}");
        nonEmpty.forEach(System.out::println);
    }
}
