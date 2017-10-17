class Solution {
    public int maxCoins(int[] nums) {
        return helper(nums, 0, nums.length-1, new int[nums.length][nums.length]);
    }

    private int helper(int[] nums, int start, int end, int[][] memo) {
        if (start > end) return 0;
        if (memo[start][end] != 0) return memo[start][end];

        int ret = 0;

        for (int i = start; i <= end; i++) {
            int l = helper(nums, start, i-1, memo);
            int r = helper(nums, i+1, end, memo);
            ret = Math.max(ret, l+r+(nums[i]*left(nums, start)*right(nums, end)));
        }

        memo[start][end] = ret;
        return ret;
    }

    private int left(int[] nums, int start) {
        if (start-1 >= 0) return nums[start-1];
        return 1;
    }

    private int right(int[] nums, int end) {
        if (end+1 < nums.length) return nums[end+1];
        return 1;
    }
}