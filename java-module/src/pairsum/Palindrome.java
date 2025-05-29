package pairsum;

public class Palindrome {

    public static void main(String[] args) {
        String initial = "preved";
        System.out.println("Initial string: " + initial);
        System.out.println("Is palindrome: " + isPalindrome(initial));
    }

    /**
     * Verifies if a string provided is a 'palindrome'
     * Checks equality of symbols at begin = end, if line of string is odd, skip middle element
     * */
    private static boolean isPalindrome(String strToVerify) {
        Character [] chars = strToVerify.chars()
                .mapToObj(c -> (char)c).toArray(Character[]::new);
        int left = 0;
        int right = chars.length - 1;
        while (left < right) {
            if (chars[left] == chars[right]) {
                left++;
                right--;
            } else {
                return false;
            }
        }
        return true;
    }

    private static boolean isPalindromeEasy(String strToVerify) {
        return new StringBuilder(strToVerify)
                .reverse()
                .toString()
                .equals(strToVerify);
    }
}
