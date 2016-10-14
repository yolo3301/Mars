public class Solution {
    public int trailingZeroes(int n) {
        if (n <= 0) return 0;

        int res = 0;
        // use long to avoid overflow
        long f = 5;
        while (n / f > 0) {
            res += n / f;
            f *= 5;
        }

        return res;
    }
}
