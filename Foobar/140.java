class Solution {
    public List<String> wordBreak(String s, List<String> wordDict) {
        Set<String> dict = new HashSet<>(wordDict);

        int maxLen = 0;
        for (String w : wordDict) {
            maxLen = Math.max(maxLen, w.length());
        }

        Map<String, List<String>> memo = new HashMap<>();

        return bt(s, dict, maxLen, memo);
    }

    private List<String> bt(String s, Set<String> dict, int maxLen, Map<String, List<String>> memo) {
        if (memo.containsKey(s)) {
            return memo.get(s);
        }

        List<String> ret = new ArrayList<>();
        for (int i = 1; i <= s.length(); i++) {
            String sub = s.substring(0, i);
            if (dict.contains(sub)) {
                if (i == s.length()) {
                    ret.add(sub);
                } else {
                    for (String next : bt(s.substring(i), dict, maxLen, memo)) {
                        ret.add(sub + " " + next);
                    }
                }
            }
        }

        memo.put(s, ret);
        return ret;
    }
}
