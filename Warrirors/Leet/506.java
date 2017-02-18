public class Solution {
    public String[] findRelativeRanks(int[] nums) {
        int[] copy = Arrays.copyOf(nums, nums.length);
        Arrays.sort(copy);
        Map<Integer, Integer> index = new HashMap<>();
        for (int i = 0; i < copy.length; i++) {
            index.put(copy[i], i);
        }

        String[] res = new String[nums.length];
        for (int i = 0; i < res.length; i++) {
            int idx = index.get(nums[i]);
            if (idx == nums.length - 1) {
                res[i] = "Gold Medal";
            } else if (idx == nums.length - 2) {
                res[i] = "Silver Medal";
            } else if (idx == nums.length - 3) {
                res[i] = "Bronze Medal";
            } else {
                res[i] = Integer.toString(nums.length - idx);
            }
        }

        return res;
    }
}