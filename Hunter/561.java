public class Solution {
    public int arrayPairSum(int[] nums) {
        if (nums.length == 0) return 0;
        Arrays.sort(nums);
        int res = 0;
        for (int i = 0; i < nums.length; i += 2) {
            res += nums[i];
        }

        return res;
    }
}