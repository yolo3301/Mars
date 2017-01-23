// https://discuss.leetcode.com/topic/72092/java-o-n-time-o-1-space
public class Solution {
    public int totalHammingDistance(int[] nums) {
        int res = 0;
        for (int i = 0; i < 32; i++) {
            int bitCnt = 0;
            for (int j : nums) {
                bitCnt += (j >> i) & 1;
            }
            res += bitCnt * (nums.length - bitCnt);
        }

        return res;
    }
}
