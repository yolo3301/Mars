public class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int[] cnt = new int[26];
        int[] cnt2 = new int[26];
        int wlen = s1.length();
        for (int i = 0; i < wlen; i++) {
            cnt[s1.charAt(i)-'a']++;
        }

        if (s2.length() < wlen) return false;

        int match = 0;
        for (int i = 0; i < s2.length(); i++) {
            char curr = s2.charAt(i);
            if (cnt[curr-'a'] > 0) {
                if (++cnt2[curr-'a'] <= cnt[curr-'a']) {
                    match++;
                }
            }

            if (i >= wlen) {
                char last = s2.charAt(i-wlen);
                if (cnt[last-'a'] > 0) {
                    if (cnt2[last-'a']-- <= cnt[last-'a']) {
                        match--;
                    }
                }
            }

            if (match == wlen) return true;
        }

        return false;
    }
}