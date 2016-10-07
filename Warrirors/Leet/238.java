public class Solution {
    public int[] productExceptSelf(int[] nums) {
        if (nums == null || nums.length == 0) return nums;

        int[] res = new int[nums.length];
        res[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            res[i] = res[i - 1] * nums[i - 1];
        }
        // after this run, res[i] contains nums[0] *** nums[i-1]

        int right = 1;
        // right is the accumulative product of right side
        for (int i = nums.length - 1; i >= 0; i--) {
            res[i] = right * res[i];
            right *= nums[i];
        }

        return res;
    }
}
