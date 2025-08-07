package coding.compression;

// Compress the string "aabcccccaaa" into "a2b1c5a3" with minimal space complexity.
public class CompressionString {

    public static String compressEasy(String input) {
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

    public static String compressMedium(String input) {
        if (input == null || input.length() <= 1) {
            return input;
        }
        StringBuilder result = new StringBuilder();

        int i = 0;
        int n = input.length();

        while (i < n) {
            char currentChar = input.charAt(i);
            int count = 1;

            // count repetitions
            while (i + 1 < n && input.charAt(i + 1) == currentChar) {
                i++;
                count++;
            }

            // append current sequence
            result.append(currentChar);
            result.append(count);
            i++;
        }

        return result.toString();
    }

    public static void main(String[] args) {
        String initial = "aabcccccaaa";
        System.out.println("Initial: " + initial);
        System.out.println("Compressed: " + compressMedium(initial));
    }
}
