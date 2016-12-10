// reference: https://discuss.leetcode.com/topic/6148/my-really-simple-java-o-n-solution-accepted/2
public class Solution {
    public int longestConsecutive(int[] nums) {
        Map<Integer, Integer> len = new HashMap<>();
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            if (!len.containsKey(nums[i])) {
                int left = len.containsKey(nums[i]-1) ? len.get(nums[i]-1) : 0;
                int right = len.containsKey(nums[i]+1) ? len.get(nums[i]+1) : 0;

                int curr = left + right + 1;
                res = Math.max(res, curr);

                len.put(nums[i], curr);
                len.put(nums[i]-left, curr);
                len.put(nums[i]+right, curr);
            }
        }

        return res;
    }
}
