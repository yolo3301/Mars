public class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        bt(candidates, 0, new ArrayList<Integer>(), 0, target, res);
        return res;
    }

    private void bt(int[] cand, int index, List<Integer> buffer, int sum, int target, List<List<Integer>> res) {
        if (sum == target) {
            res.add(new ArrayList<Integer>(buffer));
            return;
        }

        if (index == cand.length) return;

        // don't choose current
        bt(cand, index + 1, buffer, sum, target, res);

        // choose current
        int count = 0;
        while (sum + cand[index] <= target) {
            buffer.add(cand[index]);
            sum += cand[index];
            bt(cand, index + 1, buffer, sum, target, res);
            count++;
        }

        for (int i = 0; i < count; i++) {
            buffer.remove(buffer.size() - 1);
        }
    }
}
