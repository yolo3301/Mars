public class Solution {
    public String encode(String s) {
        String[][] dp = new String[s.length()][s.length()];

        for (int len = 0; len < s.length(); len++) {
            for (int i = 0; i < s.length() - len; i++) {
                int j = i + len;
                String substr = s.substring(i, j+1);
                if (j - i < 4) {
                    dp[i][j] = substr;
                } else {
                    dp[i][j] = substr;
                    for (int k = i; k < j; k++) {
                        if ((dp[i][k]+dp[k+1][j]).length() < dp[i][j].length()) {
                            dp[i][j] = dp[i][k]+dp[k+1][j];
                        }
                    }

                    for (int k = 0; k < substr.length(); k++) {
                        String rep = substr.substring(0, k+1);
                        if (rep != null && substr.length() % rep.length() == 0 && substr.replaceAll(rep, "").length() == 0) {
                            String ss = substr.length() / rep.length() + "[" + dp[i][i+k] + "]";
                            if (ss.length() < dp[i][j].length())
                                dp[i][j] = ss;
                        }
                    }
                }
            }
        }

        return dp[0][s.length()-1];
    }
}