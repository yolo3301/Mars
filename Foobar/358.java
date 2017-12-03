class Solution {
    public String rearrangeString(String s, int k) {
        int[] cnt = new int[26];
        for (char ch : s.toCharArray()) {
            cnt[ch - 'a']++;
        }

        int[] next = new int[26];

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char cand = '-';
            int maxCnt = 0;
            for (int j = 0; j < 26; j++) {
                if (cnt[j] > maxCnt && i >= next[j]) {
                    cand = (char)('a' + j);
                    maxCnt = cnt[j];
                }
            }

            if (cand == '-') return "";

            cnt[cand - 'a']--;
            next[cand - 'a'] = i + k;
            sb.append(cand);
        }

        return sb.toString();
    }
}