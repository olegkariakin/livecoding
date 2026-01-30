package coding;

public class StringToIntegerAtoi {

    static void main() {
        System.out.println("Result: " + myAtoi("-1337dfsdf234234"));
    }

    static int myAtoi(String s) {
        int n = s.length();
        int i = 0;
        int sign = 1;
        int res = 0;

        // skip spaces
        while (i < n && s.charAt(i) == ' ') i++;

        // check sign, if -+-+- it'll exist on 2nd element
        if (i < n && (s.charAt(i) == '+' || s.charAt(i) == '-')) {
            sign = (s.charAt(i) == '-') ? -1 : 1;
            i++;
        }

        // reading digits and forming a number, if leading +-+-+-+234234 this loop won't start cause '-' isn't digit
        while (i < n && Character.isDigit(s.charAt(i))) {
            int digit = (s.charAt(i) - '0');
            // Checking result overflow
            if (sign == 1 && (res > Integer.MAX_VALUE / 10 || (res == Integer.MAX_VALUE / 10 && digit > 7))) {
                return Integer.MAX_VALUE;
            }
            if (sign == -1 && (-res < Integer.MIN_VALUE / 10 || (-res == Integer.MIN_VALUE / 10 && digit > 8))) {
                return Integer.MIN_VALUE;
            }
            res = res * 10 + digit;
            i++;
        }

        return res * sign;
    }
}
