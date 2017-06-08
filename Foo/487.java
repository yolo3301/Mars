public class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int res = 0;
        int zeroLeft = 0, zeroRight = 0; // zero left is the number of 1s left to the current 0 including flipping the current 0
        for (int i = 0; i < nums.length; i++) {
            zeroRight++;
            if (nums[i] == 0) {
                zeroLeft = zeroRight;
                zeroRight = 0;
            }
            res = Math.max(res, zeroLeft + zeroRight);
        }
        return res;
    }
}