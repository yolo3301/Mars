// my way, use bt, no optimal
public class Solution {
    public int checkRecord(int n) {
        if (n == 0) return 0;
        long[][] memo = new long[8][n];
        return (int)(dp(false, false, false, 0, n, memo) % (1000000007));
    }

    private long dp(boolean doubleL, boolean singleL, boolean hasA, int index, int n, long[][] memo) {
        if (index == n) return 1;
        int k = key(doubleL, singleL, hasA);
        if (memo[k][index] != 0) return memo[k][index];

        long res = dp(false, false, hasA, index+1, n, memo);
        if (!hasA) res += dp(false, false, true, index+1, n, memo);
        if (!doubleL) {
            if (singleL) res += dp(true, true, hasA, index+1, n, memo);
            else res+= dp(false, true, hasA, index+1, n, memo);
        }

        memo[k][index] = res;
        return res;
    }

    private int key(boolean doubleL, boolean singleL, boolean hasA) {
        int res = 0;
        if (doubleL) res |= 1;
        res <<= 1;
        if (singleL) res |= 1;
        res <<= 1;
        if (hasA) res |= 1;
        return res;
    }
}

public class Solution {
    static final int M = 1000000007;
    public int checkRecord(int n) {
        long[] pOrL = new long[n+1];
        long[] p = new long[n+1];
        p[0] = 1;
        pOrL[0] = 1;
        p[1] = 1;
        pOrL[1] = 2;

        for (int i = 2; i <= n; i++) {
            p[i] = pOrL[i-1];
            pOrL[i] = (p[i] + p[i-1] + p[i-2]) % M;
        }

        long res = pOrL[n];
        for (int i = 0; i < n; i++) {
            res = (res + pOrL[i] * pOrL[n-i-1]) % M;
        }

        return (int)res;
    }
}