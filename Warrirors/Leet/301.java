// https://discuss.leetcode.com/topic/34875/easy-short-concise-and-fast-java-dfs-3-ms-solution/2
public class Solution {
    public List<String> removeInvalidParentheses(String s) {
        List<String> res = new ArrayList<>();
        bt(s, 0, 0, res, new char[] {'(', ')'});
        return res;
    }

    private void bt(String s, int index, int lastRemove, List<String> res, char[] par) {
        // find first invalid ')'
        for (int stack = 0, i = index; i < s.length(); i++) {
            if (s.charAt(i) == par[0]) stack++;
            else if (s.charAt(i) == par[1]) stack--;
            if (stack < 0) {
                for (int j = lastRemove; j <= i; j++) {
                    // This 'if' removes duplicates
                    if (s.charAt(j) == par[1] && (j == lastRemove || s.charAt(j-1) != par[1])) {
                        // why i & j ?
                        // because the string was removed 1 character !!!
                        bt(s.substring(0, j) + s.substring(j+1), i, j, res, par);
                    }
                }
                return;
            }
        }

        String reversed = new StringBuilder(s).reverse().toString();
        if (par[0] == '(') { // means just checked left to rigth
            // need to check in the other direction
            bt(reversed, 0, 0, res, new char[] {')', '('});
        } else { // means already checked both directions
            res.add(reversed);
        }
    }
}
