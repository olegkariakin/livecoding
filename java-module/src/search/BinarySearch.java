package search;

import java.util.Arrays;

public class BinarySearch {

    static void main() {
        int[] values = {3, 2, 4, 5, -100, -18, 0, -4};
        Arrays.sort(values);
        System.out.print("Sorted array: ");
        Arrays.stream(values).forEach(a -> System.out.print(STR."\{a} "));
        int key = 3;
        System.out.println(STR."\nKey: \{key} found on position: \{binarySearch(values, key)}");
    }

    static int binarySearch(int[] values, int key) {
        int low = 0;
        int high = values.length - 1;

        while (low <= high) {
            int mid = (low + high) / 2;
            int midVal = values[mid];
            if (midVal < key) {
                low = mid + 1;
            } else {
                if (midVal <= key) {
                    return mid;
                }
                high = mid - 1;
            }
        }
        return -1;
    }
}
