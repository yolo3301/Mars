public class Solution {
    public double findMaxAverage(int[] nums, int k) {
        double min = Integer.MAX_VALUE;
        double max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            min = Math.min(min, nums[i]);
            max = Math.max(max, nums[i]);
        }
        double prevMid = max, diff = Integer.MAX_VALUE;
        while (diff > 0.00001) {
            double mid = (min + max) * 0.5;
            if (valid(nums, mid, k))
                min = mid;
            else
                max = mid;
            diff = Math.abs(prevMid - mid);
            prevMid = mid;
        }

        return min;
    }

    private boolean valid(int[] nums, double mid, int k) {
        double sum = 0, prev = 0, sumMin = 0;
        for (int i = 0; i < k; i++) {
            sum += nums[i] - mid;
        }
        if (sum >= 0) return true;
        for (int i = k; i < nums.length; i++) {
            sum += nums[i] - mid;
            prev += nums[i-k] - mid;
            sumMin = Math.min(sumMin, prev);
            if (sum >= sumMin) return true;
        }
        return false;
    }
}