public class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        bt(candidates, 0, target, new ArrayList<>(), 0, res);
        return res;
    }

    private void bt(int[] cand, int index, int target, List<Integer> buffer, int sum, List<List<Integer>> res) {
        if (sum > target) return;
        if (sum == target) {
            res.add(new ArrayList<>(buffer));
            return;
        }

        if (index == cand.length) return;

        bt(cand, index + 1, target, buffer, sum, res);

        int cnt = 0;
        while (sum + cand[index] <= target) {
            cnt++;
            buffer.add(cand[index]);
            sum += cand[index];
            bt(cand, index + 1, target, buffer, sum, res);
        }

        for (int i = 0; i < cnt; i++) {
            buffer.remove(buffer.size() - 1);
        }
    }
}