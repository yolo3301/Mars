class Solution {
    public String encode(String s) {
        if (s.length() == 0) return "";

        String[][] dp = new String[s.length()][s.length()];
        for (int len = 0; len < s.length(); len++) {
            for (int i = 0; i + len < s.length(); i++) {
                int j = i+len;
                String sub = s.substring(i, j+1);
                dp[i][j] = sub;
                if (j - i >= 4) {
                    for (int k = i; k < j; k++) {
                        String cand = dp[i][k] + dp[k+1][j];
                        if (cand.length() < dp[i][j].length()) {
                            dp[i][j] = cand;
                        }
                    }

                    String tmp = sub+sub;
                    int pos = tmp.substring(1, tmp.length()-1).indexOf(sub);
                    // System.out.println(tmp + ": " + pos);
                    if (pos+1 > 0 && pos+1 < sub.length()) {
                        String cand = (sub.length() / (pos+1)) + "[" + dp[i][i+pos] + "]";
                        // System.out.println(cand);
                        if (cand.length() < dp[i][j].length()) dp[i][j] = cand;
                    }
                }
            }
        }

        return dp[0][s.length()-1];
    }
}

