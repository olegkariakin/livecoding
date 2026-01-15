package streams;

import java.util.ArrayList;
import java.util.List;

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

    public <T> void forEachConsumer(List<T> list, Consumer<T> c) {
        for (T t: list) {
            c.accept(t);
        }
    }

    static void main() {
        List<String> listOfStrings = List.of("one", "two", "", "");
        Predicate<String> nonEmptyStringPredicate = (String s) -> !s.isEmpty();
        List<String> nonEmpty = filterWithPredicate(listOfStrings, nonEmptyStringPredicate);
        System.out.println(STR."Size: \{nonEmpty.size()}");
        nonEmpty.forEach(System.out::println);
    }
}
