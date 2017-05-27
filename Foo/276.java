public class Solution {
    public int numWays(int n, int k) {
        if (n == 0) return 0;
        if (n == 1) return k;
        if (n == 2) return k*k;
        int s = k, ns = k*(k-1);
        for (int i = 2; i < n; i++) {
            int t1 = (k-1)*(s+ns);
            int t2 = ns;
            ns = t1;
            s = t2;
        }

        return s + ns;
    }
}