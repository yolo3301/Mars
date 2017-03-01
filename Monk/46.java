public class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        bt(nums, 0, new ArrayList<>(), res);
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

        Set<Integer> set = new HashSet<>();
        set.add(nums[index]);

        for (int i = index + 1; i < nums.length; i++) {
            if (!set.contains(nums[i])) {
                set.add(nums[i]);
                swap(nums, i, index);
                buffer.add(nums[index]);
                bt(nums, index + 1, buffer, res);
                buffer.remove(buffer.size() - 1);
                swap(nums, index, i);
            }
        }
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}