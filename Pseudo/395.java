public class Solution {
    public int longestSubstring(String s, int k) {
        if (s.length() < k) return 0;
        int[] cnt = new int[26];
        for (char ch : s.toCharArray()) {
            cnt[ch - 'a']++;
        }

        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < 26; i++) {
            if (cnt[i] > 0 && cnt[i] < k)
                sb.append((char)('a'+i));
        }
        sb.append(']');

        if (sb.length() == 2) return s.length();

        String[] parts = s.split(sb.toString());
        int res = 0;
        for (String p : parts) {
            if (p != null && p.length() >= k)
                res = Math.max(res, longestSubstring(p, k));
        }

        return res;
    }
}