public class Solution {
    public boolean increasingTriplet(int[] nums) {
        if (nums.length < 3) return false;
        Integer s1 = nums[0], s2 = null;

        for (int i : nums) {
            if (i <= s1) {
                s1 = i;
            } else if (s2 == null || i <= s2) {
                s2 = i;
            } else {
                return true;
            }
        }

        return false;
    }
}