public class Solution {
    public boolean search(int[] nums, int target) {
        return bs(nums, 0, nums.length - 1, target);
    }

    private boolean bs(int[] nums, int s, int e, int target) {
        if (s > e) return false;

        int m = (s + e) / 2;

        if (nums[m] == target) return true;

        if (nums[s] == nums[m]) return bs(nums, s + 1, e, target);

        if (nums[s] < nums[m]) {
            if (nums[s] <= target && target < nums[m])
                return bs(nums, s, m - 1, target);
            else
                return bs(nums, m + 1, e, target);
        } else {
            if (nums[m] < target && target <= nums[e])
                return bs(nums, m + 1, e, target);
            else
                return bs(nums, s, m - 1, target);
        }
    }
}
