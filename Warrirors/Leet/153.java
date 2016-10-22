public class Solution {
    public int findMin(int[] nums) {
        return binarySearch(0, nums.length - 1, nums);
    }

    private int binarySearch(int s, int e, int[] nums) {
        if (e - s <= 1) return Math.min(nums[s], nums[e]);

        int m = (s + e) / 2;
        if (nums[s] < nums[m]) {
            if (nums[s] < nums[e]) {
                return nums[s];
            } else {
                return binarySearch(m + 1, e, nums);
            }
        } else if (nums[s] > nums[m]) {
            return binarySearch(s, m, nums);
        } else {
            return binarySearch(s + 1, e, nums);
        }
    }
}
