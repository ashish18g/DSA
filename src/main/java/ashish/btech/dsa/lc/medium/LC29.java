package ashish.btech.dsa.lc.medium;

public class LC29 {
    public int divide(int dividend, int divisor) {
        if (dividend == divisor) return 1;
        boolean positiveSignQuo = !((dividend < 0) ^ (divisor < 0));
        dividend = dividend > 0 ? dividend : -dividend;

        int quotient = 0;
        if (dividend < 0) {
            if (divisor == -1) {
                return Integer.MAX_VALUE;
            } else if (divisor == 1) {
                return Integer.MIN_VALUE;
            } else {
                dividend = Integer.MAX_VALUE;
                divisor = divisor < 0 ? -divisor : divisor;
                if (dividend < divisor) return 0;
                dividend -= divisor;
                quotient++;
                dividend++;
            }
        } else {
            divisor = divisor < 0 ? -divisor : divisor;
            if (divisor < 0) return 0;
            else if (divisor == 1) {
                quotient = dividend;
                dividend = 0;
            }
        }
        while (dividend > 0) {
            dividend -= divisor;
            quotient++;
        }

        if (dividend < 0) {
            return (positiveSignQuo ? (quotient - 1) : -(quotient - 1));
        }

        return (positiveSignQuo ? (quotient) : -(quotient));
    }

    public static void main(String[] args) {
        LC29 blah = new LC29();
        System.err.println(blah.divide(-2147483647, -3));
    }
}
