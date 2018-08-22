class Solution {
    public int search(int[] nums, int target) {
        int s = 0, e = nums.length-1;
        while (s <= e) {
            int m = s + (e - s) / 2;
            if (nums[m] == target) return m;
            if (nums[m] < target) s = m+1;
            else e = m-1;
        }
        return -1;
    }
}