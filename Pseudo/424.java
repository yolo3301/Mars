public class Solution {
    public int characterReplacement(String s, int k) {
        if (s.length() == 0) return 0;
        int[] cnt = new int[26];
        int maxCnt = 0, res = 0;
        for (int i = 0, j = 0; i < s.length(); i++) {
            maxCnt = Math.max(maxCnt, ++cnt[s.charAt(i) - 'A']);
            if (k >= i-j+1 - maxCnt) {
                res = Math.max(res, i-j+1);
            } else {
                cnt[s.charAt(j++) - 'A']--;
                cnt[s.charAt(i--) - 'A']--;
            }
        }

        return res;
    }
}