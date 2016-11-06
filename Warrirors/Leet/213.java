public class Solution {
    public int rob(int[] nums) {
        if (nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];
        int[] mem1 = int[nums.length];
        int[] mem2 = int[nums.length];
        mem1[0] = nums[0];
        mem1[1] = nums[0];
        mem2[1] = nums[1];

        for (int i = 2; i < nums.length; i++) {
            if (i != nums.length - 1) {
                mem1[i] = Math.max(mem1[i-1], mem1[i-2] + nums[i]);
            } else {
                mem1[i] = mem1[i-1];
            }

            mem2[i] = Math.max(mem2[i-1], mem2[i-2] + nums[i]);
        }

        return Math.max(mem1[nums.length - 1], mem2[nums.length - 1]);
    }
}
