package util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.IntStream;

public class ArrayUtils {

    private ArrayUtils() {
    }

    public static void printArrayToConsole(int[] array) {
        for (int j : array) {
            System.out.print(j + " ");
        }
    }

    public static int[] sortArrayAscending(int[] array) {
        Arrays.sort(array);
        return array;
    }

    public static int[] sortArrayDescending(int[] array) {
        return IntStream.of(array)
                .boxed()
                .sorted((a, b) -> b - a)
                .mapToInt(Integer::intValue)
                .toArray();
    }

    public static List<Integer> readListFromConsole() {
        Scanner sc = new Scanner(System.in);
        var integerList = new ArrayList<Integer>();
        int input;

        System.out.println("Please enter a list of integers until -100500 is entered");

        while (true) {
            System.out.print("Print an integer: ");
            if (sc.hasNext()) {
                input = sc.nextInt();
                if (input == -100500) {
                    break;
                }
                integerList.add(input);
            } else {
                System.out.print("Invalid input. Please try again: ");
                sc.next();
            }
        }

        return integerList;
    }

    public static int[] readArrayFromConsole() {
        return readListFromConsole().stream()
                .mapToInt(Integer::intValue)
                .toArray();
    }
}
