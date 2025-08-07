package coding.compression;

// Compress the string "aabcccccaaa" into "a2b1c5a3" with minimal space complexity.
public class CompressionString {

    public static String compress(String input) {
        if (input == null || input.length() <= 1) {
            return input;
        }

        StringBuilder result = new StringBuilder();
        int count = 1;
        char current = input.charAt(0);

        for (int i = 1; i < input.length(); i++) {
            if (input.charAt(i) == current) {
                count++;
            } else {
                result.append(current);
                result.append(count);
                current = input.charAt(i);
                count = 1;
            }
        }

        result.append(current);
        result.append(count);

        return result.toString();
    }

    public static void main(String[] args) {
        String initial = "aabcccccaaa";
        System.out.println("Initial: " + initial);
        System.out.println("Compressed: " + compress(initial));
    }
}
