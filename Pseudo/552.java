public class Solution {
    private int mod = 1000000007;
    public int checkRecord(int n) {
        if (n == 0) return 0;

        long[] p = new long[n+1];
        long[] pl = new long[n+1];
        p[0] = 1;
        pl[0] = 1;
        p[1] = 1;
        pl[1] = 2;
        for (int i = 2; i <= n; i++) {
            p[i] = pl[i-1];
            pl[i] = (p[i]+p[i-1]+p[i-2]) % mod;
        }

        long res = pl[n];
        for (int i = 0; i < n; i++) {
            res = (res + pl[i]*pl[n-i-1]) % mod;
        }

        return (int)res;
    }
}