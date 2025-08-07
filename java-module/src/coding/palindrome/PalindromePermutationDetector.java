package coding.palindrome;

public class PalindromePermutationDetector {

    /*
    This challenge is all about understanding character frequencies and efficient counting. You'll also need to apply some logical reasoning to determine if a string is symmetric.

    --Sample Task
    Check if "tactcoa" can be rearranged into a palindrome.
     */
    public static boolean checkPalindrome(String str) {
        if (str == null || str.length() < 3) {
            return false;
        }
        int[] charCount = new int[128];
        // Count character frequencies
        for (Character c: str.toCharArray()) {
            charCount[c]++;
        }

        // Count characters with odd frequency
        int oddFrequency = 0;
        for (int count: charCount) {
            if (count % 2 != 0) {
                oddFrequency++;
            }
            if (oddFrequency > 1) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        String str = "tactcoa";
        System.out.println("Initial string to verify if is palindrome: " + str + " : " + checkPalindrome(str));
    }
}
