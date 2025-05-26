package pairsum;

import static util.ArrayUtils.*;

public class PairSumSorted {

    public static void main(String[] args) {
        //TODO consider this to move to utils
        System.out.println("Populate array of integers");
        int[] array = readArrayFromConsole();
        System.out.println("Array before sorting");
        printArrayToConsole(array);
        System.out.println("Sorted array");
        printArrayToConsole(sortArrayAscending(array));
        //TODO ends
        int target = 2;
        System.out.println("Result: ");
        printArrayToConsole(pairSumSorted(array, target));
    }

    //TODO move to readme
    /**
     * Find a first pair of elements withing sorted array which sum
     * equals to the target, return empty array otherwise
     * For example
     * [-5, -2, 3, 4, 6] target = 7
     * Result: [2, 3]
     * */
    public static int[] pairSumSorted(int[] arr, int target) {
        int[] emptyArray = {};
        if (arr == null || arr.length < 2) {
            return emptyArray;
        }
        int left = 0;
        int right = arr.length - 1;
        int sum;
        while (left < right) {
            sum = arr[left] + arr[right];
            if (sum == target) {
                return new int[]{left, right};
            }
            if (sum > target) {
                right--;
            }
            if (sum < target) {
                left++;
            }
        }
        return emptyArray;
    }
}
