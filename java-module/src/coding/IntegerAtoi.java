package coding;

public class IntegerAtoi {

    static void main() {
        System.out.println("Result: " + myAtoi("-1337dfsdf234234"));
    }

    static int myAtoi(String s) {
        int n = s.length();
        int i = 0;
        int sign = 1;
        long res = 0;

        // skip spaces
        while (i < n && s.charAt(i) == ' ') i++;

        // identify + or - sign
        if (i < n && (s.charAt(i) == '+' || s.charAt(i) == '-')) {
            sign = (s.charAt(i) == '-') ? -1 : 1;
            i++;
        }

        while (i < n && Character.isDigit(s.charAt(i))) {
            res = res * 10 + (s.charAt(i) - '0');
            i++;

            // check overflow using long
            if (sign == 1 && res > Integer.MAX_VALUE) return Integer.MAX_VALUE;
            if (sign == -1 && -res < Integer.MIN_VALUE) return Integer.MIN_VALUE;
        }

        return (int) (res * sign);
    }
}
