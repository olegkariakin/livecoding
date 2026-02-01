package interview.basics;

import java.util.Arrays;
import java.util.stream.Collectors;

public class ReverseStringWords {

    static void main() {
        String initial = " Some words here";
        System.out.println(STR."Reverse words: \{initial} - \{reverseWordsJava21(initial)}");
    }

    static String reversedWords(String initial) {
        StringBuilder reversed = new StringBuilder();
        String[] words = initial.split(" ");
        for (int i = words.length - 1; i >= 0; i--) {
            reversed.append(words[i]);
            if (i != 0) reversed.append(" ");
        }
        return reversed.toString();
    }

    static String reverseWordsJava21(String initial) {
        return String.join(" ", Arrays.asList(initial.split(" "))
                .reversed());
    }
}
