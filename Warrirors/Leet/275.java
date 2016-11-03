public class Solution {
    private int res = 0;
    public int hIndex(int[] citations) {
        bs(citations, 0, citations.length - 1);
        return res;
    }

    private void bs(int[] nums, int s, int e) {
        if (s > e) return;

        int m = (s + e) / 2;
        if (nums[m] >= nums.length - m) {
            res = Math.max(res, nums.length - m);
            bs(nums, s, m - 1);
        } else {
            bs(nums, m + 1, e);
        }
    }
}
