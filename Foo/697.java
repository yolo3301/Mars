class Solution {
    public int findShortestSubArray(int[] nums) {
        if (nums.length == 0) return 0;

        int maxFreq = 1;
        Map<Integer, int[]> cnt = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (!cnt.containsKey(nums[i])) {
                cnt.put(nums[i], new int[]{1, i, i});
            } else {
                int[] cur = cnt.get(nums[i]);
                cur[0]++;
                cur[2] = i;
                maxFreq = Math.max(maxFreq, cur[0]);
                cnt.put(nums[i], cur);
            }
        }

        int ret = nums.length;
        for (int k : cnt.keySet()) {
            int[] cur = cnt.get(k);
            if (cur[0] == maxFreq) {
                ret = Math.min(ret, cur[2] - cur[1]);
            }
        }

        return ret;
    }
}
