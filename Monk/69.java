public class Solution {
    public int mySqrt(int x) {
        if (x == 0 || x == 1) return x;

        long s = 1, e = x - 1;
        while (s <= e) {
            long m = s + (e - s) / 2;
            long y = m * m;
            if (y == x) return (int)m;
            else if (y < x) {
                s = m + 1;
            } else {
                e = m - 1;
            }
        }

        return (int)e;
    }
}