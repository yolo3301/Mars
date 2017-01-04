// both way should work depends on how many words are there. Somehow can't pass the OJ
public class Solution {
    public List<String> wordBreak(String s, Set<String> wordDict) {
        List<String> res = new ArrayList<>();
        if (s.isEmpty() || wordDict.isEmpty()) return res;

        // int maxLen = 0;
        // for (String w : wordDict) maxLen = Math.max(maxLen, w.length());

        List<String>[] dp = new ArrayList[s.length()];
        for (int i = 0; i < s.length(); i++) {
            dp[i] = new ArrayList<>();
            /*for (int j = Math.max(0, i - maxLen + 1); j <= i; j++) {
                String curr = s.substring(j, i + 1);
                if (wordDict.contains(curr)) {
                    if (j == 0) {
                        dp[i].add(curr);
                    } else if (!dp[j-1].isEmpty()) {
                        for (String prev : dp[j-1]) {
                            dp[i].add(prev + " " + curr);
                        }
                    }
                }
            }*/
            String sub = s.substring(0, i+1);
            for (String w : wordDict) {
                if (sub.endsWith(w)) {
                    int j = i - w.length() + 1;
                    if (j == 0) {
                        dp[i].add(sub);
                    } else {
                        for (String prev : dp[j-1]) {
                            dp[i].add(prev + " " + w);
                        }
                    }
                }
            }
        }

        return dp[s.length() - 1];
    }
}
