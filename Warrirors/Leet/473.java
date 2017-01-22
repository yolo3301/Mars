public class Solution {
    public boolean makesquare(int[] nums) {
        if (nums.length < 4) return false;
        int sum = 0;
        for (int n : nums) sum += n;
        if (sum % 4 != 0) return false;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length / 2; i++) {
            int t = nums[i];
            nums[i] = nums[nums.length - 1 - i];
            nums[nums.length - 1 - i] = t;
        }

        return bt(nums, 0, new int[4], sum / 4);
    }

    private boolean bt(int[] nums, int index, int[] sums, int target) {
        if (index == nums.length) {
            return (sums[0] == target && sums[1] == target && sums[2] == target);
        }

        for (int i = 0; i < 4; i++) {
            if (sums[i] + nums[index] <= target) {
                sums[i] += nums[index];
                if (bt(nums, index + 1, sums, target)) return true;
                sums[i] -= nums[index];
            }
        }

        return false;
    }
}
