public class Solution {
    public int myAtoi(String str) {
        boolean neg = (str.charAt(0) == '-');
        long res = 0;
        for (int i = neg ? 1 : 0; i < str.length(); i++) {
            res *= 10;
            res += str.charAt(i) - '0';
            if (neg) {
                if (-res < Integer.MIN_VALUE) return Integer.MIN_VALUE;
            } else {
                if (res > Integer.MAX_VALUE) return Integer.MAX_VALUE;
            }
        }

        if (neg) return (int)(-res);
        else return (int) res;
    }
}
