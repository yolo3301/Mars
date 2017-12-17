class Solution {
    public int minCostClimbingStairs(int[] cost) {
        if (cost.length <= 1) return 0;
        int min1 = 0, min2 = 0;
        for (int i = 2; i <= cost.length; i++) {
            int cur = Math.min(min1 + cost[i-2], min2 + cost[i-1]);
            min1 = min2;
            min2 = cur;
        }

        return min2;
    }
}