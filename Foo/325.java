public class Solution {
    public int maxSubArrayLen(int[] nums, int k) {
        int sum = 0, res = 0;
        Map<Integer, Integer> prev = new HashMap<>();
        prev.put(0, -1);
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (prev.containsKey(sum-k)) {
                res = Math.max(res, i - prev.get(sum-k));
            }
            if (!prev.containsKey(sum)) prev.put(sum, i);
        }

        return res;
    }
}