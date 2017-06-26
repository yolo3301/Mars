public class Solution {
    public int strobogrammaticInRange(String low, String high) {
        for (int len = low.length(); len <= high.length(); len++) {
            bt(low, high, new char[len], 0, len-1);
        }
        return res;
    }

    int res = 0;
    char[][] pairs = new char[][]{{'0','0'},{'1','1'},{'6','9'},{'8','8'},{'9','6'}};

    private void bt(String low, String high, char[] c, int s, int e) {
        if (s > e) {
            String cand = new String(c);
            if (cand.compareTo(low) >= 0 && cand.compareTo(high) <= 0)
                res++;
            return;
        }

        for (char[] p : pairs) {
            c[s] = p[0];
            c[e] = p[1];
            if (c.length != 1 && c[0] == '0')
                continue;
            if (s == e && c[s] != c[e])
                continue;

            bt(low, high, c, s+1, e-1);
        }
    }
}