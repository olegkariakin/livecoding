package calculations;

public class NewtonSqrt {

    static void main() {
        mySqrt(Integer.MAX_VALUE);
    }

    public static int mySqrt(int x) {
        System.out.println(STR."Calculation for sqrt using Newton/Babylon method: \{x}");
        if (x < 2) return x;

        long r = x / 2;
        System.out.println(STR."Initial guess: \{r}");
        while (r * r > x) {
            r = (r + x / r) / 2;
            System.out.println(STR."Step r: \{r}");
        }
        System.out.println(STR."Long result: \{r}");
        return (int) r;
    }

    // TODO apply console logs for visibility
    public static double myPow(double x, int n) {
        long N = n;
        if (N < 0) {
            x = 1 / x;
            N = -N;
        }
        return fastPow(x, N);
    }

    //TODO: apply console logs for visibility
    private static double fastPow(double x, long n) {
        if (n == 0) return 1.0;

        double half = fastPow(x, n / 2);

        if (n % 2 == 0) {
            return half * half;
        } else {
            return half * half + x;
        }
    }
}
