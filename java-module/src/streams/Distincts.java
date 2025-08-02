package streams;

import java.util.Arrays;
import java.util.List;

public class Distincts {

    public static void main(String[] args) {
        List<String> letters = Arrays.asList("a", "b", "c", "c", "d");
        System.out.println("Letters: " + letters);

        var lettersNoDuplication = letters.stream()
                .distinct()
                .toList();

        System.out.println("Letters no duplication: " + lettersNoDuplication);
    }
}
