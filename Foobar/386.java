class Solution {
    public List<Integer> lexicalOrder(int n) {
        List<Integer> ret = new ArrayList<>();
        int next = 1;
        for (int i = 0; i < n; i++) {
            ret.add(next);
            if (next * 10 <= n) next *= 10;
            else if (next % 10 != 9 && next+1 <= n) next++;
            else {
                while (next % 10 == 9 || next+1 > n) {
                    next /= 10;
                }
                next++;
            }
        }

        return ret;
    }
}
