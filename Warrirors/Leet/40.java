public class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(candidates);
        bt(candidates, target, 0, 0, new ArrayList<Integer>(), res);
        return res;
    }

    private void bt(int[] nums, int target, int index, int sum, List<Integer> buffer, List<List<Integer>> res) {
        if (sum == target) {
            res.add(new ArrayList<Integer>(buffer));
        }

        if (sum >= target || index >= nums.length) return;

        int curr = nums[index];
        int next = index;
        while (next < nums.length && nums[next] == curr) {
            next++;
        }

        bt(nums, target, next, sum, buffer, res);

        int acc = curr;
        for (int i = index; i < next; i++) {
            buffer.add(curr);
            bt(nums, target, next, sum + acc, buffer, res);
            acc += curr;
        }

        for (int i = index; i < next; i++) {
            buffer.remove(buffer.size() - 1);
        }
    }
}
