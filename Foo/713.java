/*

*/
class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if (k == 1) return 0;
        int ret = 0;
        long product = 1;

        for (int start = 0, end = 0; end < nums.length; end++) {
            product *= nums[end];
            while (start <= end && product >= k) {
                product /= nums[start++];
            }

            ret += end - start + 1;
        }

        return ret;
    }
}
