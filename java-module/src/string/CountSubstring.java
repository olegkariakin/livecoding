package string;

public class CountSubstring {

    static void main() {
        String initial = "helhelohe";
        String valueToFind = "he";
        System.out.println("Recursive search of substring: " + countSubstringBuiltIn(initial, valueToFind));
    }

    static int countSubstringsRecursive(String input, String valueToFind) {
        // recursive termination
        if (input.length() < valueToFind.length()) {
            return 0;
        }
        int count;
        String remaining;

        if (input.startsWith(valueToFind)) {
            count = 1;
            remaining = input.substring(valueToFind.length());
        } else {
            remaining = input.substring(1);
            count = 0;
        }
        // recursive descent
        return countSubstringsRecursive(remaining, valueToFind) + count;
    }

    static int countSubstringsRecursiveShort(String input, String valueToFind) {
        return input.length() < valueToFind.length() ? 0 : (input.startsWith(valueToFind) ? 1 : 0) +
                countSubstringsRecursiveShort(input.substring(1), valueToFind);
    }

    static int countSubstringBuiltIn(String input, String valueToFind) {
        int count = 0;
        int index = 0;

        while ((index = input.indexOf(valueToFind, index)) != -1) {
            count++;
            index += valueToFind.length();
        }

        return count;
    }

    static int countSubstringsIterative(String input, String valueToFind) {
        if (valueToFind.isEmpty() || input.length() < valueToFind.length()) return 0;
        int count = 0;
        int n = input.length();
        int m = valueToFind.length();

        for (int i = 0; i <= n - m; i++) {
            if (input.charAt(i) == valueToFind.charAt(0)) {
                boolean match = true;
                for (int j = 1; j < m; j++) {
                    if (input.charAt(i + j) != valueToFind.charAt(j)) {
                        match = false;
                        break;
                    }
                }
                if (match) {
                    count++;
                    i += m - 1;
                }
            }
        }

        return count;
    }
}
