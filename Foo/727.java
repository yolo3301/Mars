class Solution {
    public String minWindow(String S, String T) {
        int slen = S.length();
        int tlen = T.length();

        // Means the start index of matching T[0..j] and S[0..i]
        int[][] dp = new int[tlen][slen];

        for (int i = 0; i < s.length(); i++) {
            dp[0][i] = S.charAt(i) == T.charAt(0) ? i : -1;
        }

        for (int j = 1; j < tlen; j++) {
            int last = -1;
            Arrays.fill(dp[j], -1);
            for (int i = 0; i < slen; i++) {
                if (last >= 0 && S.charAt(i) == T.charAt(j)) {
                    dp[j][i] = last; // If this is a matching char, then use the previous start index
                }
                if (dp[j-1][i] >= 0) { // Means there is matching between T[0..j-1] and S[0..i]
                    last = dp[j-1][i]; // Thus update the last start index
                }
            }
        }

        int start = 0, end = slen;
        for (int e = 0; e < slen; e++) {
            int s = dp[tlen-1][e];
            if (s >= 0 && e - s < end - start) {
                start = s;
                end = e;
            }
        }

        return (end < slen) ? S.substring(start, end+1) : "";
    }
}