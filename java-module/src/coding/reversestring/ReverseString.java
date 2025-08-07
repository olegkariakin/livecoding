package coding.reversestring;

import java.util.stream.Collectors;

public class ReverseString {

    public static String reverseStringEasy(String input) {
        return new StringBuilder(input).reverse().toString();
    }

    public static String reverseStringHard(String input) {
        int left = 0;
        int right = input.length() - 1;

        char[] inputArray = input.toCharArray();
        char[] outputArray = new char[inputArray.length];

        while (left < right) {
            char temp = inputArray[left];
            outputArray[left] = inputArray[right];
            outputArray[right] = temp;
            left++;
            right--;
        }
        return String.valueOf(outputArray);
    }

    public static String reverseStringStream(String input) {
        return input.chars()
                .mapToObj(c -> (char) c)
                .toList()
                .stream()
                .collect(Collectors.collectingAndThen(
                    Collectors.toList(), list -> {
                        java.util.Collections.reverse(list);
                        return list.stream();
                    }
                ))
                .map(String::valueOf)
                .collect(Collectors.joining());
    }

    public static void main(String[] args) {
        String initial = "adbcsdslkjpeoiiz";
        System.out.println("Initial: " + initial);

        System.out.println("Reversed: " + reverseStringStream(initial));
    }
}
