public class Solution {
    public int splitArray(int[] nums, int m) {
        if (nums.length == 0) return 0;

        long sum = 0, max = nums[0];
        for (int i : nums) {
            sum += i;
            max = (long)Math.max(i, max);
        }

        if (m == 1) return (int)sum;

        while (max < sum) {
            long mid = max + (sum - max) / 2;
            if (valid(nums, m, mid)) {
                sum = mid;
            } else {
                max = mid + 1;
            }
        }

        return (int)max;
    }

    private boolean valid(int[] nums, int m, long mid) {
        long sum = 0;
        int cnt = 1;
        for (int i : nums) {
            sum += i;
            if (sum > mid) {
                sum = i;
                cnt++;
                if (cnt > m) return false;
            }
        }

        return true;
    }
}