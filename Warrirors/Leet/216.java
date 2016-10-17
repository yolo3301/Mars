public class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new ArrayList<>();
        bt(1, 0, 0, k, n, new ArrayList<Integer>(), res);

        return res;
    }

    private void bt(int index, int count, int sum, int k, int n, List<Integer> buffer, List<List<Integer>> r) {
        if (count == k && sum == n) {
            r.add(new ArrayList<Integer>(buffer));
            return;
        }
        if (index > 9) return;
        if (count == k) return;
        if (sum >= n) return;

        // use current
        if (index <= n - sum) {
            buffer.add(index)
            bt(index + 1, count + 1, sum + index, k, n, buffer, r);
            buffer.remove(buffer.size() - 1);
        } else {
            return;
        }

        // don't use current
        bt(index + 1, count, sum, k, n, buffer, r);
    }
}
