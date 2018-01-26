class Solution {
    public String reorganizeString(String S) {
        int[] cnt = new int[26];
        for (char c : S.toCharArray()) {
            cnt[c - 'a']++;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < S.length(); i++) {
            int prev = i == 0 ? -1 : (sb.charAt(i-1) - 'a');
            int cur = findMax(cnt, prev);
            if (cur == -1)
                return "";
            sb.append((char)('a' + cur));
            cnt[cur]--;
        }

        return sb.toString();
    }

    private int findMax(int[] cnt, int prev) {
        int max = -1;
        for (int i = 0; i < 26; i++) {
            if (i == prev) continue;
            if (cnt[i] > 0 && (max == -1 || cnt[i] > cnt[max]))
                max = i;
        }
        return max;
    }
}