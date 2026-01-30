package string;

public class CountSubstring {

    static void main() {
        String initial = "helhelohe";
        String valueToFind = "he";
        System.out.println("Recursive search of substring: " + countSubstringsIterative(initial, valueToFind));
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

    static int countSubstringsIterative(String input, String valueToFind) {
        char[] inputs = input.toCharArray();
        char[] toFind = valueToFind.toCharArray();
        int count = 0;

        for (int i = 0; i < inputs.length; i++) {
            if (inputs[i] == toFind[0]) {
                int left = i;
                for (char c : toFind) {
                    if (inputs[left] != c) {
                        break;
                    } else {
                        left++;
                    }
                }
                count++;
                i += toFind.length - 1;
            }
        }

        return count;
    }
}
