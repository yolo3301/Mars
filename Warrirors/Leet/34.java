public class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] res = new int[2];
        res[0] = findStart(nums, 0, nums.length - 1, target);
        res[1] = findEnd(nums, 0, nums.length - 1, target);
        return res;
    }

    private int findStart(int[] nums, int s, int e, int target) {
        if (s > e) return -1;
        int m = (s + e) / 2;

        if (nums[m] == target && (m - 1 < s || nums[m - 1] < target)) {
            return m;
        }

        if (nums[m] >= target) {
            return findStart(nums, s, m - 1, target);
        } else {
            return findStart(nums, m + 1, e, target);
        }
    }

    private int findEnd(int[] nums, int s, int e, int target) {
        if (s > e) return -1;
        int m = (s + e) / 2;

        if (nums[m] == target && (m + 1 > e || nums[m + 1] > target)) {
            return m;
        }

        if (nums[m] <= target) {
            return findEnd(nums, m + 1, e, target);
        } else {
            return findEnd(nums, s, m - 1, target);
        }
    }
}
