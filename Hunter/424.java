public class Solution {
    public int characterReplacement(String s, int k) {
        int[] cnt = new int[26];
        int b = 0, e = 0, maxCnt = 0, res = 0;
        for (e = 0; e < s.length(); e++) {
            maxCnt = Math.max(maxCnt, ++cnt[s.charAt(e) - 'A']);
            while (e - b + 1 - maxCnt > k) {
                --cnt[s.charAt(b++) - 'A'];
            }

            res = Math.max(res, e - b + 1);
        }

        return res;
    }
}