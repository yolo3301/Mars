public class Solution {
    public int splitArray(int[] nums, int m) {
        if (nums.length == 0) return 0;
        long max = 0, sum = 0;
        for (int i : nums) {
            sum += i;
            max = (long)Math.max(max, i);
        }

        // binary search
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
        int cnt = 1;
        long sum = 0;
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