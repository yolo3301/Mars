public class Solution {
    public int longestConsecutive(int[] nums) {
        if (nums.length == 0) return 0;
        int res = 0;
        // map edge to len
        Map<Integer, Integer> lens = new HashMap<>();
        for (int i : nums) {
            if (!lens.containsKey(i)) {
                int left = lens.getOrDefault(i-1, 0);
                int right = lens.getOrDefault(i+1, 0);

                int curr = left + right + 1;
                res = Math.max(res, curr);

                lens.put(i, curr);
                lens.put(i-left, curr);
                lens.put(i+right, curr);
            }
        }

        return res;
    }
}