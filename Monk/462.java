public class Solution {
    public int minMoves2(int[] nums) {
        Arrays.sort(nums);
        int res = 0;
        for (int i = 0, j = nums.length - 1; i < j; i++, j--) {
            res += nums[j] - nums[i];
        }

        return res;
    }
}