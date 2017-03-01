public class Solution {
    public boolean increasingTriplet(int[] nums) {
        if (nums.length < 3) return false;
        Integer s1 = nums[0];
        Integer s2 = null;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] <= s1) {
                s1 = nums[i];
            } else if (s2 == null || nums[i] <= s2) {
                s2 = nums[i];
            } else {
                return true;
            }
        }

        return false;
    }
}