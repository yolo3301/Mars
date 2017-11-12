class Solution {
    public int pivotIndex(int[] nums) {
        int sumAll = 0;
        for (int n : nums) sumAll += n;

        int left = 0;
        for (int i = 0; i < nums.length; i++) {
            int right = sumAll - (left + nums[i]);
            if (left == right) return i;
            left += nums[i];
        }

        return -1;
    }
}