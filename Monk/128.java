public class Solution {
    public int longestConsecutive(int[] nums) {
        Map<Integer, Integer> len = new HashMap<>();
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            if (!len.containsKey(nums[i])) {
                int left = len.getOrDefault(nums[i] - 1, 0);
                int right = len.getOrDefault(nums[i] + 1, 0);

                int curr = left + right + 1;
                res = Math.max(res, curr);

                // Extend the edges
                len.put(nums[i], curr);
                len.put(nums[i] - 1, curr);
                len.put(nums[i] + 1, curr);
            }
        }

        return res;
    }
}