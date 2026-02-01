package interview.basics;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FirstUniqueCharacter {

    static void main() {
        String s = "lleettccoode";
        char result = findFirstUniqueStream(s);
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

    // in case of ASCII chars only used 256 array
    // time complexity O(n) space complexity O (n)
    // array consumes less than a map
    static char findFirstUniqueArray(String input) {
        int[] freqs = new int[256];

        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (c < 256) {
                freqs[c]++;
            }
        }

        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (c < 256 && freqs[c] == 1) {
                return c;
            }
        }
        return '\0';
    }

    static char findFirstUniqueStream(String input) {
        return input.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(
                        Function.identity(),
                        LinkedHashMap::new,
                        Collectors.counting()
                ))
                .entrySet()
                .stream()
                .filter(entry -> entry.getValue() == 1)
                .map(Map.Entry::getKey)
                .findFirst()
                .orElse('\0');
    }
}
