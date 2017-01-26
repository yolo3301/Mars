public class Solution {
    private int res = 0;
    public int findTargetSumWays(int[] nums, int S) {
        bt(nums, 0, 0, S);
        return res;
    }

    private void bt(int[] nums, int index, long sum, int target) {
        if (index == nums.length) {
            if (sum == target) res++;
            return;
        }

        bt(nums, index + 1, sum + nums[index], target);
        bt(nums, index + 1, sum - nums[index], target);
    }
}

// https://discuss.leetcode.com/topic/76243/java-15-ms-c-3-ms-o-ns-iterative-dp-solution-using-subset-sum-with-explanation
public class Solution {
    public int findTargetSumWays(int[] nums, int S) {
        if (nums.length == 0) return 0;
        int sum = 0;
        for (int i : nums) sum += i;
        if (sum < S || (sum + S) % 2 != 0) return 0;
        int sub = (sum + S) / 2;

        /*int[] dp1 = new int[sub + 1];
        dp1[0] = 1;
        for (int i : nums) {
            for (int j = sub; j >= i; j--) {
                dp1[j] += dp1[j-i];
            }
        }

        return dp[sub];*/
        
        // short version is so subtle!!!
        int[][] dp = new int[nums.length + 1][sub + 1];
        for (int i = 0; i <= nums.length; i++) dp[i][0] = 1; 
        
        for (int i = 1; i <= nums.length; i++) {
            for (int j = sub; j >= 0; j--) {
                int l = j >= nums[i-1] ? dp[i-1][j-nums[i-1]] : 0;
                dp[i][j] = dp[i-1][j] + l;
            }
        }

        return dp[nums.length][sub];
    }
}