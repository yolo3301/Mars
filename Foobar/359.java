class Solution {
    public String rearrangeString(String s, int k) {
        int[] cnt = new int[26];
        int[] next = new int[26];
        for (char ch : s.toCharArray()) {
            cnt[ch - 'a']++;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            int curr = findNext(cnt, next, i);
            if (curr == -1) return "";
            sb.append((char)('a' + curr));
            cnt[curr]--;
            next[curr] = i + k;
        }

        return sb.toString();
    }

    private int findNext(int[] cnt, int[] next, int index) {
        int max = 0, res = -1;
        for (int i = 0; i < 26; i++) {
            if (cnt[i] > 0 && cnt[i] >= max && index >= next[i]) {
                max = cnt[i];
                res = i;
            }
        }
        return res;
    }
}