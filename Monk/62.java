public class Solution {
    public int uniquePaths(int m, int n) {
        if (m == 1 || n == 1) return 1;

        if (m > n) {
            int t = m;
            m = n;
            n = t;
        }
        m--;
        n--;

        long res = 1;
        for (int i = 1; i <= m; i++) {
            res *= (n + i);
            res /= i;
        }

        return (int)res;
    }
}