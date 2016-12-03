public class Solution {
    public int reverse(int x) {
        if (x == 0) return 0;
        boolean neg = x < 0;

        long z = x;
        if (neg) z = -z;

        long y = 0;
        while (z != 0) {
            y *= 10;
            y += (z % 10);
            z /= 10;
        }

        if (!neg && y > Integer.MAX_VALUE) return 0;
        if (neg && -y < Integer.MIN_VALUE) return 0;

        return (int)(neg ? -y : y);
    }
}
