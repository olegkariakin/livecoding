package hashmaps;

import java.util.Arrays;
import java.util.HashMap;

import static util.ArrayUtils.*;

public class PairSumUnsorted {

    public static void main(String[] args) {
        System.out.println("Populate array of integers");
        int[] array = readArrayFromConsole();
        System.out.println("Unsorted array");
        printArrayToConsole(array);
        System.out.println("Enter target: ");
        int target = readIntegerFromConsole();
        System.out.println(String.format("Target is: %s", target));
        System.out.println("Complementary pair: " +
                Arrays.toString(pairSumUnsortedTwoPass(array, target)));
    }

    private static int[] pairSumUnsortedTwoPass(int[] array, int target) {
        var numMap = new HashMap<Integer, Integer>();
        // First pass: Populate the hash map with each number and its index.
        for (int i = 0; i < array.length; i++) {
            numMap.put(array[i], i);
        }
        // Second pass: Check for each number's complement in the hash map
        for (int i = 0; i < array.length; i++) {
            int num = array[i];
            int complement = target - num;
            if (numMap.containsKey(complement) && numMap.get(complement) != i) {
                return new int []{i, numMap.get(complement)};
            }
        }
        return new int []{};
    }
}
