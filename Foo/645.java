public class Solution {
    public int[] findErrorNums(int[] nums) {
        int dup = -1;
        for (int i = 0; i < nums.length; i++) {
            int ab = Math.abs(nums[i]);
            if (nums[ab-1] < 0) dup = ab;
            nums[ab-1] = -nums[ab-1];
        }

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0 && i != dup-1) return new int[]{dup, i+1};
        }

        return new int[2];
    }
}