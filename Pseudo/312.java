public class Solution {
    public int maxCoins(int[] nums) {
        return dp(nums, 0, nums.length-1, new int[nums.length][nums.length]);
    }

    private int dp(int[] nums, int s, int e, int[][] memo) {
        if (s > e) return 0;
        if (memo[s][e] != 0) return memo[s][e];

        int res = 0;
        for (int i = s; i <= e; i++) {
            int sum = dp(nums, s, i-1, memo);
            sum += dp(nums, i+1, e, memo);
            int left = (s-1 >= 0) ? nums[s-1] : 1;
            int right = (e+1 < nums.length) ? nums[e+1] : 1;
            sum += nums[i] * left * right;

            res = Math.max(res, sum);
        }

        memo[s][e] = res;
        
        return res;
    }
}