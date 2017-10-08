class Solution {
    public int longestConsecutive(int[] nums) {
        if (nums.length == 0) return 0;
        Map<Integer, Integer> len = new HashMap<>();
        int ret = 0;

        for (int n : nums) {
            if (len.containsKey(n)) continue;
            int left = len.getOrDefault(n-1, 0);
            int right = len.getOrDefault(n+1, 0);
            int cur = left+right+1;
            len.put(n, cur);
            len.put(n-left, cur);
            len.put(n+right, cur);

            ret = Math.max(ret, cur);
        }

        return ret;
    }
}
