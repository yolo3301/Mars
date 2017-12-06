class Solution {
    public int deleteAndEarn(int[] nums) {
        int[] cnt = new int[100001];
        for (int n : nums) cnt[n] += n;

        int[] dp = new int[10001];
        dp[1] = cnt[1];

        for (int i = 2; i <= 10000; i++) {
            dp[i] = Math.max(dp[i-2] + cnt[i], dp[i-1]);
        }

        return dp[10000];
    }
}