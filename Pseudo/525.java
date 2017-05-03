public class Solution {
    public int findMaxLength(int[] nums) {
        if (nums.length <= 1) return 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int zeroCnt = 0, oneCnt = 0, res = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) oneCnt++;
            else zeroCnt++;

            if (map.containsKey(oneCnt - zeroCnt)) {
                res = Math.max(res, i - map.get(oneCnt - zeroCnt));
            } else {
                map.put(oneCnt - zeroCnt, i);
            }
        }

        return res;
    }
}