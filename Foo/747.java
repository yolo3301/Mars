class Solution {
    public int dominantIndex(int[] nums) {
        if (nums.length == 0) return -1;
        int maxIndex = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[maxIndex])
                maxIndex = i;
        }

        for (int i = 0; i < nums.length; i++) {
            if (maxIndex != i) {
                if (nums[maxIndex] < 2 * nums[i])
                    return -1;
            }
        }

        return maxIndex;
    }
}