public class Solution {
    public List<String> removeInvalidParentheses(String s) {
        List<String> res = new ArrayList<>();
        bt(s, 0, 0, res, new char[]{'(',')'});
        return res;
    }

    private void bt(String s, int index, int lastRemoved, List<String> res, char[] p) {
        int cnt = 0;
        for (int i = index; i < s.length(); i++) {
            if (s.charAt(i) == p[0]) cnt++;
            else if (s.charAt(i) == p[1]) cnt--;

            if (cnt < 0) {
                for (int j = lastRemoved; j <= i; j++) {
                    if (s.charAt(j) == p[1] && (j == lastRemoved || s.charAt(j-1) != p[1])) {
                        bt(s.substring(0,j)+s.substring(j+1), i, j, res, p);
                    }
                }
                return;
            }
        }

        String r = new StringBuilder(s).reverse().toString();
        if (p[0] == '(') {
            bt(r, 0, 0, res, new char[]{')','('});
        } else {
            res.add(r);
        }
    }
}