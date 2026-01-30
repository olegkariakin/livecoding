package string;

public class ReverseStringRecursively {

    static void main() {
        String initial = "lskdfjlksdjflksjfdl-02394-02934;jswdf;lsjdf;";
        System.out.println("Initial: " + initial);
        System.out.println("Reversed: " + reverse(initial));
    }

    private static String reverse(String input) {
        return input.length() <= 1 ? input : reverse(input.substring(1)) + input.charAt(0);
    }
}
