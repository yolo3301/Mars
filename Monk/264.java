public class Solution {
    public int nthUglyNumber(int n) {
        int[] res = new int[n];
        res[0] = 1;
        int p2 = 0, p3 = 0, p5 = 0;

        for (int i = 1; i < n; i++) {
            int min = Math.min(2 * res[p2], Math.min(3 * res[p3], 5 * res[p5]));
            res[i] = min;
            if (2 * res[p2] == min) p2++;
            if (3 * res[p3] == min) p3++;
            if (5 * res[p5] == min) p5++;
        }

        return res[n-1];
    }
}