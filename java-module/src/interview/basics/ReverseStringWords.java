package interview.basics;

public class ReverseStringWords {

    static void main() {
        String initial = " Some words here";
        System.out.println(STR."Reverse words: \{initial} - \{reversedWords(initial)}");
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
}
