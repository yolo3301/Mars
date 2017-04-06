public class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        if (nums.length < 2) return false;
        int sum = 0;
        Map<Integer, Integer> prev = new HashMap<>();
        prev.put(0, -1);
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (k != 0) sum %= k;
            if (prev.containsKey(sum)) {
                if (i - prev.get(sum) > 1) return true;
            } else {
                prev.put(sum, i);
            }
        }

        return false;
    }
}