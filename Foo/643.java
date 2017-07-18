public class Solution {
    public double findMaxAverage(int[] nums, int k) {
        double sum = 0, res = Double.MIN_VALUE;
        for (int i = 0; i < k; i++) {
            sum += nums[i];
        }
        res = sum / k;

        for (int i = k; i < nums.length; i++) {
            sum -= nums[i-k];
            sum += nums[i];
            res = Math.max(res, sum / k);
        }

        return res;
    }
}