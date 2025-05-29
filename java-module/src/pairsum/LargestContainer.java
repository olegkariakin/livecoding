package pairsum;

import java.util.Arrays;

import static util.ArrayUtils.readArrayFromConsole;

public class LargestContainer {

    public static void main(String[] args) {
        System.out.println("Populate array of integers");
        int[] array = readArrayFromConsole();
        System.out.println("Initial array: " + Arrays.toString(array));
        System.out.println("Max volume is: " + largestContainerVolume(array));
    }

    /**
     * Calculate maximum amount of water that can fit into a container
     * which heights got specified by array values
     *     |
     *   | |   |
     *   | |   | |
     *   | |   | |
     *   | |   | |
     *   | | | | |
     * | | | | | |
     * | | | | | |
     * 2 7 8 3 7 6
     * */
    private static int largestContainerVolume(int[] heights) {
        int max = 0;
        int volume;
        int left = 0;
        int right = heights.length - 1;

        while (left < right) {
            volume = Math.min(heights[left], heights[right]) * (right - left);
            System.out.println("Current volume is: " + volume + " for: " + heights[left] + " " + heights[right]);
            if (volume > max) {
                max = volume;
            }
            if (heights[left] < heights[right]) {
                left++;
            } else if (heights[left] > heights[right]) {
                right--;
            } else if (heights[left] == heights[right]) {
                left++;
                right--;
            }
        }

        return max;
    }
}
