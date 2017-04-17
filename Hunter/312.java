public class Solution {
    public int maxCoins(int[] nums) {
        if (nums.length == 0) return 0;
        int[][] dp = new int[nums.length][nums.length];

        for (int len = 0; len <= nums.length; len++) {
            for (int i = 0; i + len <= nums.length; i++) {
                for (int j = i; j < i + len; j++) {
                    int curr = nums[j] * val(nums, i-1) * val(nums, i+len);
                    curr += j > 0 ? dp[i][j-1] : 0;
                    curr += j + 1 < nums.length ? dp[j+1][i+len-1] : 0;
                    dp[i][i+len-1] = Math.max(dp[i][i+len-1], curr);
                }
            }
        }

        return dp[0][nums.length-1];
    }

    private int val(int[] nums, int i) {
        if (i >= 0 && i < nums.length) return nums[i];
        return 1;
    }
}