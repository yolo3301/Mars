public class Solution {
    public int thirdMax(int[] nums) {
        if (nums.length == 0) return Integer.MIN_VALUE;
        if (nums.length == 1) return nums[0];
        if (nums.length == 2) return Math.max(nums[0], nums[1]);
        long m1 = Long.MIN_VALUE, m2 = Long.MIN_VALUE, m3 = Long.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > m1) {
                m3 = m2;
                m2 = m1;
                m1 = nums[i];
            } else if (nums[i] == m1) {
                continue;
            } else if (nums[i] > m2) {
                m3 = m2;
                m2 = nums[i];
            } else if (nums[i] == m2) {
                continue;
            } else if (nums[i] > m3) {
                m3 = nums[i];
            }
        }

        return m3 != Long.MIN_VALUE ? (int)m3 : (int)m1;
    }
}
