class Solution {
    public int findPeakElement(int[] nums) {
        int i = 0, j = nums.length-1;
        while (i < j) {
            int m = i + (j-i) / 2;
            int l = (m-1 < 0) ? Integer.MIN_VALUE : nums[m-1];
            int r = (m+1 >= nums.length) ? Integer.MIN_VALUE : nums[m+1];
            if (nums[m] > l && nums[m] > r) return m;
            if (l > nums[m]) {
                j = m-1;
            } else {
                i = m+1;
            }
        }

        return i;
    }
}
