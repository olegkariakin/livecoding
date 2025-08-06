package slidingwindow;

public class LongestCommonPrefixAnagram {

    public static int longestCommonPrefixAnagram(String str1, String str2) {
        int n1 = str1.length();
        int n2 = str2.length();
        int[] count1 = new int[26];
        int[] count2 = new int[26];

        for (int i = 0; i < n1; i++) {
            count1[str1.charAt(i) - 'a']++;
        }

        for (int i = 0; i < n2; i++) {
            count2[str2.charAt(i) - 'a']++;
        }

        int result = 0;
        for (int i = 0; i < 26; i++) {
            result += Math.min(count1[i], count2[i]);
        }
        return result;
    }

    public static void main(String[] args) {
        String str1 = "abcdef";
        String str2 = "fedcba";

        int result = longestCommonPrefixAnagram(str1, str2);
        System.out.println("Length of the longest common anagram: " + result);
    }
}
