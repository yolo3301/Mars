public class Solution {
    public List<List<Integer>> getFactors(int n) {
        if (n == 1) return new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();
        bt(2, n, n, new ArrayList<>(), res);
        return res;
    }

    private void bt(int start, int left, int n, List<Integer> buffer, List<List<Integer>> res) {
        if (left == 1) {
            res.add(new ArrayList<>(buffer));
            return;
        }

        for (int j = start; j <= left && j < n; j++) {
            if (left % j != 0) continue;
            buffer.add(j);
            bt(j, left / j, n, buffer, res);
            buffer.remove(buffer.size()-1);
        }
    }
}