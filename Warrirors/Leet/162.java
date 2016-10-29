public class Solution {
    public int findPeakElement(int[] nums) {
        return binarySearch(nums, 0, nums.length - 1);
    }

    private int binarySearch(int[] nums, int s, int e) {
        if (s == e) return s;
        if (s + 1 == e) {
            if (nums[s] > nums[e]) return s;
            else return e;
        }

        int m = (s + e) / 2;
        if (nums[m] > nums[m-1] && nums[m] > nums[m+1])
            return m;
        else if (nums[m] < nums[m-1])
            return binarySearch(nums, s, m - 1);
        else
            return binarySearch(nums, m + 1, e);
    }
}
