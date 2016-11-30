public class Solution {
    public int mySqrt(int x) {
        if (x == 0) return 0;
        int s = 1, e = x / 2;
        while (true) {
            int m = s + (e - s) / 2;
            if (x / m < m) {
                e = m - 1;
            } else {
                if (x / (m + 1) < (m + 1))
                    return m;
                else
                    s = m + 1;
            }
        }
    }
}
