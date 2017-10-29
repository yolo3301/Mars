class Solution {
    public int findLength(int[] A, int[] B) {
        int alen = A.length;
        int blen = B.length;
        if (alen == 0 || blen == 0) return 0;

        int[][] dp = new int[alen+1][blen+1];
        int ret = 0;

        for (int i = 1; i <= alen; i++) {
            for (int j = 1; j <= blen; j++) {
                if (A[i-1] == B[j-1]) {
                    dp[i][j] = dp[i-1][j-1] + 1;
                    ret = Math.max(ret, dp[i][j]);
                }
            }
        }

        return ret;
    }
}