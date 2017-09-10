class Solution {
    public int strobogrammaticInRange(String low, String high) {
        for (int len = low.length(); len <= high.length(); len++) {
            bt(low, high, new char[len], 0, len-1);
        }
        return res;
    }

    int res = 0;
    char[][] nums = new char[][]{{'1', '1'}, {'6', '9'}, {'8', '8'}, {'9', '6'}, {'0', '0'}};

    private void bt(String low, String high, char[] chs, int s, int e) {
        if (s > e) {
            String cand = new String(chs);
            if ((cand.length() == low.length() && cand.compareTo(low) < 0)
                || (cand.length() == high.length() && cand.compareTo(high) > 0)) {
                return;
            }
            res++;
            return;
        }

        for (char[] p : nums) {
            if (chs.length != 1 && s == 0 && p[0] == '0') continue;
            if (s == e && p[0] != p[1]) continue;
            chs[s] = p[0];
            chs[e] = p[1];
            bt(low, high, chs, s+1, e-1);
        }
    }
}