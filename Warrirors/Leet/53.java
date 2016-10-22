public class Solution {
    public int maxSubArray(int[] nums) {
        if (nums.length == 0) return 0;
        int res = Integer.MIN_VALUE;
        int curr = nums[0];
        for (int i = 1; i < nums.length; i++) {
            curr = Math.max(res + nums[i], nums[i]);
            res = Math.max(res, curr);
        }

        return res;
    }
}
