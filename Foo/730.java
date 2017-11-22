class Solution {
    int mod = 1000000007;

    public int countPalindromicSubsequences(String S) {
        TreeSet<Integer>[] index = new TreeSet[26];
        for (int i = 0; i < 26; i++) index[i] = new TreeSet<>();
        for (int i = 0; i < S.length(); i++) {
            index[S.charAt(i) - 'a'].add(i);
        }

        Integer[][] memo = new Integer[S.length()][S.length()];
        return bt(S, 0, S.length()-1, index, memo);
    }

    private int bt(String S, int start, int end, TreeSet<Integer>[] index, Integer[][] memo) {
        if (start > end) return 0;
        if (memo[start][end] != null) return memo[start][end];

        long ret = 0;

        for (int i = 0; i < 26; i++) {
            Integer nextStart = index[i].ceiling(start);
            Integer nextEnd = index[i].floor(end);
            if (nextStart == null || nextStart > end) continue;
            
            ret += (nextStart != nextEnd) ? 2 : 1;
            ret += bt(S, nextStart+1, nextEnd-1, index, memo);
        }

        memo[start][end] = (int)(ret % mod);
        return memo[start][end];
    }
}