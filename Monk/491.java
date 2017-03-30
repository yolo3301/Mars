public class Solution {
    public List<List<Integer>> findSubsequences(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        bt(nums, 0, new ArrayList<>(), res);
        return res;
    }

    private void bt(int[] nums, int index, List<Integer> buffer, List<List<Integer>> res) {
        if (buffer.size() > 1) {
            res.add(new ArrayList<>(buffer));
        }

        if (index == nums.length) return;

        Set<Integer> set = new HashSet<>();
        for (int i = index; i < nums.length; i++) {
            if (index > 0 && nums[i] < nums[index-1]) continue;
            if (set.contains(nums[i])) continue;
            set.add(nums[i]);
            buffer.add(nums[i]);
            bt(nums, i+1, buffer, res);
            buffer.remove(buffer.size() - 1);
        }
    }
}