package prefixsum;

import java.util.HashMap;
import java.util.Map;

public class PrefixSum {

    public static int countSubarrayWithSum(int[] nums, int k) {
        Map<Integer, Integer> prefixSumCount = new HashMap<>();
        prefixSumCount.put(0, 1);

        int prefixSum = 0; // Initialize prefix sum
        int count = 0; // Initialize result

        for (int num: nums) {
            prefixSum += num; // Update our running prefix sum

            // Check if there exists a prefix sum that when substracted from current prefix sum gives k
            if (prefixSumCount.containsKey(prefixSum - k)) {
                count += prefixSumCount.get(prefixSum - k);
            }

            // Update the hashmap for the current prefix sum
            prefixSumCount.put(prefixSum, prefixSumCount.getOrDefault(prefixSum, 0) + 1);
        }
        return count;
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 1};
        int k = 1;
        System.out.println("Count of subarrays with sum: " + k + " is: " + countSubarrayWithSum(nums, k));

        int[] nums2 = {2, 3, 4, -2, -1, 1, 5, 8};
        int k2 = 5;
        System.out.println("Count of subarrays with sum: " + k2 + " is: " + countSubarrayWithSum(nums2, k2));
    }
}
