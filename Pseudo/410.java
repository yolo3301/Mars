public class Solution {
    public int splitArray(int[] nums, int m) {
        long sum = 0, max = 0;
        for (int i : nums) {
            sum += i;
            max = Math.max(max, i);
        }

        long s = max, e = sum;
        while (s < e) {
            long mid = s + (e - s) / 2;
            if (subarray(nums, mid, m)) {
                e = mid;
            } else {
                s = mid+1;
            }
        }

        return (int)s;
    }

    private boolean subarray(int[] nums, long target, int m) {
        long sum = 0;
        int group = 1;
        for (int i : nums) {
            sum += i;
            if (sum > target) {
                group++;
                if (group > m) return false;
                sum = i;
            }
        }

        return true;
    }
}