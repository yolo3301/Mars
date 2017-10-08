class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> dict = new HashSet<>(wordDict);
        boolean[] dp = new boolean[s.length()+1];
        dp[0] = true;

        for (int i = 1; i <= s.length(); i++) {
            for (int j = i; j > 0; j--) {
                String sub = s.substring(j-1, i);
                if (dict.contains(sub) && dp[j-1]) {
                    dp[i] = true;
                    break;
                }
            }
        }

        return dp[s.length()];
    }
}
