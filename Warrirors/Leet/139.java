public class Solution {
    public boolean wordBreak(String s, Set<String> wordDict) {
        if (s.length() == 0) return true;
        if (wordDict.isEmpty()) return false;

        int maxLen = 0;
        for (String w : wordDict) {
            maxLen = Math.max(maxLen, w.length());
        }

        int mem[] = new int[s.length()];

        return bt(s, 0, wordDict, maxLen, mem);
    }

    private boolean bt(String s, int index, Set<String> dict, int maxLen, int[] mem) {
        if (index == s.length()) return true;
        if (mem[index] != 0) return mem[index] == 1 ? true : false;

        int upper = Math.min(index + maxLen, s.length());
        for (int i = upper; i > index; i--) {
            String curr = s.substring(index, i);
            if (dict.contains(curr)) {
                if (bt(s, i, dict, maxLen, mem)) {
                    mem[index] = 1;
                    return true;
                }
            }
        }

        mem[index] = 2;
        return false;
    }
}
