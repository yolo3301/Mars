public class Solution {
    public int minSubArrayLen(int s, int[] nums) {
        if (nums.length == 0) return 0;
        int i = 0, sum = 0, res = Integer.MAX_VALUE;
        for (int j = 0; j < nums.length; j++) {
            sum += nums[j];
            if (sum >= s) {
                while (i <= j && sum >= s) {
                    sum -= nums[i++];
                }

                res = Math.min(res, j - i + 2);
            }
        }

        return res == Integer.MAX_VALUE ? 0 : res;
    }
}