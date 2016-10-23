// reference: https://discuss.leetcode.com/topic/37426/concise-java-solution-with-comments
public class Solution {
    public boolean increasingTriplet(int[] nums) {
        if (nums.length < 3) return false;
        int small = Integer.MAX_VALUE, big = Integer.MAX_VALUE;
        for (int i : nums) {
            if (i <= small) small = i;
            else if (i <= big) big = i;
            else return true;
        }

        return false;
    }
}
