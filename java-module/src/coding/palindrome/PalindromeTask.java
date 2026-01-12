package coding.palindrome;

public class PalindromeTask {

    static void main() {
        String a = "ABC";
        String b = "XYZ";
        System.out.println(STR."A: \{a} B: \{b}");
        a = a + b;
        b = a.substring(0, a.length() - b.length());
        a = a.substring(b.length());
        System.out.println(STR."A: \{a} B: \{b}");
    }

    public static boolean isPalindrome(String input) {
        if (input == null || input.isBlank()) {
            return false;
        } else {
            int left = 0;
            int right = input.length() - 1;
            while (left < right) {
                if (input.charAt(left) != input.charAt(right)) {
                    return false;
                }
                left ++;
                right --;
            }
            return true;
        }
    }

    public static String reverseString(String input) {
        if (input == null || input.isBlank()) {
            return input;
        } else {
            char[] outputChars = input.toCharArray();
            int left = 0;
            int right = outputChars.length - 1;
            while (left < right) {
                char temp = outputChars[right];
                outputChars[right] = outputChars[left];
                outputChars[left] = temp;
                left++;
                right--;
            }
            return new String(outputChars);
        }
    }
}
