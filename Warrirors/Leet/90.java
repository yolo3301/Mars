public class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
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

        int curr = nums[index];
        int next = index;
        while (next < nums.length && nums[next] == curr) {
            next++;
        }

        for (int i = index; i < next; i++) {
            buffer.add(curr);
            bt(nums, next, buffer, res);
        }

        for (int i = index; i < next; i++) {
            buffer.remove(buffer.size() - 1);
        }

        bt(nums, next, buffer, res);
    }
}
