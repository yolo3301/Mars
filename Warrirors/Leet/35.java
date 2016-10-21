public class Solution {
    public int searchInsert(int[] nums, int target) {
        return binarySearch(0, nums.length - 1, nums, target);
    }

    private int binarySearch(int s, int e, int[] nums, int target) {
        if (s > e) return s;

        int m = (s + e) / 2;
        if (nums[m] == target) return m;
        if (nums[m] < target) return binarySearch(m + 1, e, nums, target);
        else return binarySearch(s, m - 1, nums, target);
    }
}
