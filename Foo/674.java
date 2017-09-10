class Solution {
    public int findLengthOfLCIS(int[] nums) {
        if (nums.length == 0) return 0;
        int res = 1;
        int len = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i-1]) {
                len++;
                res = Math.max(res, len);
            } else {
                len = 1;
            }
        }
        return res;
    }
}