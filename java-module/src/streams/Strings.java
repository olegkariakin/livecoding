package streams;

import java.util.Arrays;
import java.util.List;

public class Strings {

    public static void main(String[] args) {
        List<String> colors = Arrays.asList("rEd", "OrangE", "YelloW", "blue");
        System.out.println("Colors: " + colors);

        var colorsUpperCase = colors.stream()
                .map(String::toUpperCase)
                .toList();
        System.out.println("Colors to uppercase: " + colorsUpperCase);

        var colorsLowerCase = colors.stream()
                .map(String::toLowerCase)
                .toList();
        System.out.println("Colors to lowercase: " + colorsLowerCase);
    }
}
