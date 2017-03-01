public class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        if (nums.length < 2 || k <= 0) return false;
        Map<Integer, Integer> index = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (index.containsKey(nums[i])) {
                if (i - index.get(nums[i]) <= k) return true;
            }
            index.put(nums[i], i);
        }

        return false;
    }
}