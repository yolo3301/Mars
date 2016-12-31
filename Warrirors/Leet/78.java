public class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        bt(nums, 0, new ArrayList<Integer>(), res);
        return res;
    }

    private void bt(int[] nums, int index, List<Integer> buffer, List<List<Integer>> res) {
        if (index == nums.length) {
            res.add(new ArrayList<Integer>(buffer));
            return;
        }

        buffer.add(nums[index]);
        bt(nums, index + 1, buffer, res);
        buffer.remove(buffer.size() - 1);

        bt(nums, index + 1, buffer, res);
    }
}
