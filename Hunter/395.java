public class Solution {
    public int longestSubstring(String s, int k) {
        if (k == 0) return 0;
        int[] cnt = new int[26];
        for (int i = 0; i < s.length(); i++) {
            cnt[s.charAt(i) - 'a']++;
        }

        StringBuilder sb = new StringBuilder();
        sb.append('[');
        for (int i = 0; i < 26; i++) {
            if (cnt[i] > 0 && cnt[i] < k) {
                char ch = (char)('a' + i);
                sb.append(ch);
            }
        }
        sb.append(']');

        if (sb.length() == 2) return s.length();

        // use regex to split is more efficient
        String[] parts = s.split(sb.toString());
        int res = 0;
        for (String p : parts) {
            if (p != null && p.length() >= k) {
                res = Math.max(res, longestSubstring(p, k));
            }
        }

        return res;
    }
}