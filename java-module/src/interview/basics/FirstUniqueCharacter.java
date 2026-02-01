package interview.basics;

public class FirstUniqueCharacter {

    static void main() {
        String s = "lleettccoode";
        char result = findFirstUniqueTwoPointers(s);
        System.out.println(result != '\0' ? result : "No unique chars");
    }

    // O(n^2) complexity, memory O(1)
    static char findFirstUniqueTwoPointers(String input) {
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (input.indexOf(c) == input.lastIndexOf(c)) {
                return c;
            }
        }
        return '\0';
    }
}
