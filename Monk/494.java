public class Solution {
    public int findTargetSumWays(int[] nums, int S) {
        if (nums.length == 0) return 0;
        int sum = 0;
        for (int i : nums) sum += i;
        if (sum < S || (sum + S) % 2 != 0) return 0;

        int sub = (sum + S) / 2;
        int[][] dp = new int[nums.length+1][sub+1];
        dp[0][0] = 1;

        for (int i = 1; i <= nums.length; i++) {
            for (int j = 0; j <= sub; j++) {
                int m = j >= nums[i-1] ? dp[i-1][j-nums[i-1]] : 0;
                dp[i][j] = dp[i-1][j] + m;
            }
        }

        return dp[nums.length][sub];
    }
}