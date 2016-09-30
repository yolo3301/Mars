public class Solution {
    public int singleNumber(int[] nums) {
        int r = nums[0];
        for (int i = 1; i < nums.length; i++) {
            r ^= nums[i];
        }
        return r;
    }
}
