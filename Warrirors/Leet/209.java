public class Solution {
    public int minSubArrayLen(int s, int[] nums) {
        if (nums.length == 0) return 0;
        int sum = nums[0], b = 0, e = 0, res = Integer.MAX_VALUE;

        while (e < nums.length) {
            if (sum >= s) {
                int len = e - b + 1;
                res = Math.min(res, len);

                sum -= nums[b++];
                if (b > e) {
                    if (e + 1 >= nums.length) break;
                    sum += nums[++e];
                }
            } else {
                if (e + 1 >= nums.length) break;
                sum += nums[++e];
            }
        }

        return (res == Integer.MAX_VALUE) ? 0 : res;
    }
}
