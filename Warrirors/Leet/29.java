public class Solution {
    public int divide(int dividend, int divisor) {
        if (divisor == 0) return Integer.MAX_VALUE;
        if (divisor == 1) return dividend;
        if (divisor == -1) {
            if (dividend != Integer.MIN_VALUE) return -dividend;
            else return Integer.MAX_VALUE;
        }

        boolean neg = (dividend > 0 && divisor < 0) || (dividend < 0 && divisor > 0);

        long de = Math.abs((long) dividend);
        long dr = Math.abs((long) divisor);

        long res = helper(de, dr);

        if (neg) {
            if (-res < Integer.MIN_VALUE) return Integer.MIN_VALUE;
            else return (int)(-res);
        } else {
            if (res > Integer.MAX_VALUE) return Integer.MAX_VALUE;
            else return (int) res;
        }
    }

    private long helper(long de, long dr) {
        if (de == dr) return 1;
        if (de == 0 || de < dr) return 0;

        int shift = 0;
        while (de >= (dr << shift)) {
            shift++;
        }

        long left = de - (dr << (shift - 1));
        long curr = (1 << (shift - 1));

        return curr + helper(left, dr);
    }
}
