package interview.basics;

import java.util.HashMap;
import java.util.Map;

public class FirstUniqueCharacter {

    static void main() {
        String s = "lleettccoode";
        char result = findFirstUniqueMap(s);
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

    // O(n) complexity, O(n) memory 3xN, map, 2 implicit char[] arrays of initial string
    static char findFirstUniqueMap(String input) {
        Map<Character, Integer> map = new HashMap<>();
        for (char c : input.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        for (char c : input.toCharArray()) {
            if (map.get(c) == 1) return c;
        }
        return '\0';
    }
}
