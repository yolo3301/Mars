public class Solution {
    public int maxCoins(int[] nums) {
        if (nums.length == 0) return 0;
        int[][] dp = new int[nums.length][nums.length];

        for (int l = 1; l <= nums.length; l++) {
            for (int i = 0; i + l <= nums.length; i++) {
                for (int j = i; j < i + l; j++) {
                    int curr = nums[j] * val(nums, i - 1) * val(nums, i + l);
                    curr += j == i ? 0 : dp[i][j-1];
                    curr += j == i + l - 1 ? 0 : dp[j+1][i+l-1];
                    dp[i][i+l-1] = Math.max(dp[i][i+l-1], curr);
                }
            }
        }

        return dp[0][nums.length - 1];
    }

    private int val(int[] nums, int index) {
        if (index < 0 || index >= nums.length) return 1;
        else return nums[index];
    }
}