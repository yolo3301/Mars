public class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        if (s.length() == 0) return res;

        List<List<String>>[] par = new ArrayList[s.length()];
        List<String> tmp = new ArrayList<>();
        tmp.add(s.substring(0, 1));
        par[0] = new ArrayList<>();
        par[0].add(tmp);

        boolean[][] dp = new boolean[s.length()][s.length()];
        for (int i = 0; i < s.length(); i++) dp[i][i] = true;

        for (int i = 1; i < s.length(); i++) {
            par[i] = new ArrayList<>();

            for (int j = i; j >= 0; j--) {
                if (s.charAt(i) == s.charAt(j) && (j >= i - 1 || dp[j+1][i-1])) {
                    dp[j][i] = true;
                    String curr = s.substring(j, i+1);
                    if (j == 0) {
                        List<String> t = new ArrayList<>();
                        t.add(curr);
                        par[i].add(t);
                    } else {
                        for (List<String> pre : par[j-1]) {
                            List<String> t = new ArrayList<>(pre);
                            t.add(curr);
                            par[i].add(t);
                        }
                    }
                }
            }
        }

        return par[s.length() - 1];
    }
}