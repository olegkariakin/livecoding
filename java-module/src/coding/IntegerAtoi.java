package coding;

import java.util.ArrayDeque;
import java.util.Deque;

public class IntegerAtoi {

    static void main() {
        System.out.println("Result: " + myAtoi("-1337dfsdf234234"));
    }

    static int myAtoi(String s) {
        Deque<Integer> stack = new ArrayDeque<>();
        char[] chars = s.toCharArray();
        boolean isNumber = false;
        boolean isPositive = true;

        for (char c : chars) {
            //not started, ignore any leading whitespaces till a digit is found
            if (!isNumber) {
                if (c == ' ') {
                    continue;
                }
                if (c == '-') {
                    isPositive = false;
                    isNumber = true;
                    continue;
                }
                if (c == '+') {
                    isPositive = true;
                    isNumber = true;
                    continue;
                }
            }
            // scanning the number
            if (c >= '0' && c <= '9') {
                isNumber = true;
                stack.add((c - '0'));
                continue;
            }
            //stop scanning when its number and not digit is found
            if (isNumber && (c < '0' || c > '9')) {
                break;
            }
            if (!isNumber &&(c != '+' || c != '-') && (c < '0' || c > '9')) {
                break;
            }
        }

        if (stack.isEmpty()) {
            return 0;
        }

        long result = 0;
        while (!stack.isEmpty()) {
            int digit = stack.pollFirst();
            result = result * 10 + digit;

            if (isPositive && result > Integer.MAX_VALUE) return Integer.MAX_VALUE;
            if (!isPositive && -result < Integer.MIN_VALUE) return Integer.MIN_VALUE;
        }
        return isPositive ? (int) result: (int) -result;
    }
}
