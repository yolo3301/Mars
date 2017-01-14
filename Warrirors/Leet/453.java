// https://discuss.leetcode.com/topic/66557/java-o-n-solution-short
public class Solution {
    public int minMoves(int[] nums) {
        if (nums.length <= 1) return 0;
        int min = nums[0];
        for (int i : nums) min = Math.min(min, i);
        int res = 0;
        for (int i : nums) res += i - min;
        return res;
    }
}
