public class Solution {
    public int findMaxLength(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int res = 0, zero = 0, one = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) zero++;
            else one++;

            if (map.containsKey(zero-one)) {
                res = Math.max(res, i - map.get(zero-one));
            } else {
                map.put(zero-one, i);
            }
        }

        return res;
    }
}