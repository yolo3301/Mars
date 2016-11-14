public class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        bt(nums, 0, new ArrayList<Integer>(), res);
        return res;
    }

    private void bt(int[] nums, int index, List<Integer> buffer, List<List<Integer>> res) {
        if (index == nums.length) {
            res.add(new ArrayList<Integer>(buffer));
            return;
        }

        Set<Integer> used = new HashSet<>();
        for (int i = index; i < nums.length; i++) {
            if (!used.contains(nums[i])) {
                used.add(nums[i]);

                swap(nums, i, index);
                buffer.add(nums[index]);
                bt(nums, index + 1, buffer, res);
                buffer.remove(buffer.size() - 1);
                swap(nums, i, index);
            }
        }
    }

    private void swap(int[] nums, int i, int j) {
        if (i == j) return;
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
