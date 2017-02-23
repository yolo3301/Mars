public class Solution {
    public int missingNumber(int[] nums) {
        boolean metZero = false;
        for (int i = 0; i < nums.length; i++) {
            int curr = Math.abs(nums[i]);
            if (curr < nums.length) {
                if (nums[curr] == 0)
                    metZero = true;
                else
                    nums[curr] = -nums[curr];
            }
        }

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0 || (nums[i] == 0 && !metZero))
                return i;
        }

        return nums.length;
    }
}