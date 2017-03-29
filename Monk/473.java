public class Solution {
    public boolean makesquare(int[] nums) {
        if (nums.length < 4) return false;

        int sum = 0;
        for (int i : nums) sum += i;

        if (sum % 4 != 0) return false;

        Arrays.sort(nums);
        for (int i = 0; i < nums.length / 2; i++) {
            int t = nums[i];
            nums[i] = nums[nums.length - 1 - i];
            nums[nums.length - 1 - i] = t;
        }

        return bt(nums, 0, new int[]{0,0,0,0}, sum / 4);
    }

    private boolean bt(int[] nums, int index, int[] sums, int target) {
        if (index == nums.length) {
            boolean res = true;
            for (int s : sums) res &= (s == target);
            return res;
        }

        for (int i = 0; i < 4; i++) {
            if (sums[i] + nums[index] <= target) {
                sums[i] += nums[index];
                if (bt(nums, index+1, sums, target))
                    return true;
                sums[i] -= nums[index];
            }
        }

        return false;
    }
}