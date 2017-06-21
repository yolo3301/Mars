public class Solution {
    public List<String> wordBreak(String s, List<String> wordDict) {
        int maxLen = 0;
        for (String w : wordDict) {
            maxLen = Math.max(maxLen, w.length());
        }
        Set<String> dict = new HashSet<>(wordDict);
        Map<String, List<String>> memo = new HashMap<>();

        return bt(s, dict, maxLen, memo);
    }

    private List<String> bt(String s, Set<String> dict, int maxLen, Map<String, List<String>> memo) {
        if (memo.containsKey(s)) {
            return memo.get(s);
        }

        List<String> res = new ArrayList<>();

        for (int i = 1; i <= s.length() && i <= maxLen; i++) {
            String curr = s.substring(0, i);
            if (dict.contains(curr)) {
                if (i == s.length()) {
                    res.add(curr);
                } else {
                    for (String suffix : bt(s.substring(i), dict, maxLen, memo)) {
                        res.add(curr + " " + suffix);
                    }
                }
            }
        }

        memo.put(s, res);

        return res;
    }
}