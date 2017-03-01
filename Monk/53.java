public class Solution {
    public int maxSubArray(int[] nums) {
        if (nums.length == 0) return 0;
        int dp = 0, res = Integer.MIN_VALUE;

        for (int i = 0; i < nums.length; i++) {
            dp = Math.max(nums[i], dp + nums[i]);
            res = Math.max(res, dp);
        }

        return res;
    }
}