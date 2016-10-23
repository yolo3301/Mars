public class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        bt(1, n, k, new ArrayList<Integer>(), res);
        return res;
    }

    private void bt(int i, int n, int k, List<Integer> buffer, List<List<Integer>> res) {
        if (buffer.size() == k) {
            res.add(new ArrayList<Integer>(buffer));
            return;
        }

        buffer.add(i);
        bt(i + 1, n, k, buffer, res);
        buffer.remove(buffer.size() - 1);

        if (n - i >= k - buffer.size()) {
            bt(i + 1, n, k, buffer, res);
        }
    }
}
