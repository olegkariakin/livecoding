package streams;

import java.util.Comparator;
import java.util.List;

public class StartingWith {

    public static void main(String[] args) {
        var colors = List.of("Red", "Green", "Blue", "Yellow");
        System.out.println("Colors list: " +colors);

        var filteredByRCount = colors.stream()
                .filter(color -> color.contains("e"))
                .map(String::toLowerCase)
                .sorted(Comparator.reverseOrder())
                .toList();
        System.out.println("Filtered by R count: " + filteredByRCount);
    }
}
