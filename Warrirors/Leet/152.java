public class Solution {
    public int maxProduct(int[] nums) {
        int res = nums[0];
        int max = nums[0], min = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int currMax = Math.max(nums[i], Math.max(nums[i] * max, nums[i] * min));
            int currMin = Math.min(nums[i], Math.min(nums[i] * max, nums[i] * min));
            max = currMax;
            min = currMin;
            res = Math.max(res, max);
        }

        return res;
    }
}
