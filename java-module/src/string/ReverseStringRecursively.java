package string;

public class ReverseStringRecursively {

    static void main() {
        String initial = "lskdfjlksdjflksjfdl-02394-02934;jswdf;lsjdf;";
        System.out.println("Initial: " + initial);
        System.out.println("Reversed: " + reverse(initial));
    }

    private static String reverse(String input) {
        if (input.length() <= 1)
            return input;
        char firstChar = input.charAt(0);
        String remaining = input.substring(1);

        // recursive descent
        return reverse(remaining) + firstChar;
    }
}
