public class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        if (s.length() == 0) return true;
        if (wordDict.isEmpty()) return false;

        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        Set<String> dict = new HashSet<>(wordDict);

        for (int i = 1; i <= s.length(); i++) {
            for (int j = i; j > 0; j--) {
                if (dict.contains(s.substring(j-1, i)) && dp[j-1]) {
                    dp[i] = true;
                    break;
                }
            }
        }

        return dp[s.length()];
    }
}