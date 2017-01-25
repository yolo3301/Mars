public class Solution {
    private int[][] memo;
    public boolean PredictTheWinner(int[] nums) {
        int len = nums.length;
        memo = new int[len][len];

        int sum = 0;
        for (int i : nums) sum += i;

        int p1 = maxValue(0, len - 1, nums);
        return (p1 >= sum - p1);
    }

    private int maxValue(int start, int end, int[] nums) {
        if (end > start) return 0;
        if (end == start) return nums[start];
        if (memo[start][end] != 0) return memo[start][end];

        memo[start][end] = Math.max(nums[start] + Math.min(maxValue(start + 1, end - 1, nums), maxValue(start + 2, end, nums)),
                                    nums[end] + Math.min(maxValue(start + 1, end - 1, nums), maxValue(start, end - 2, nums)));

        return memo[start][end];
    }
}