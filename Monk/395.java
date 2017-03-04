public class Solution {
    public int longestSubstring(String s, int k) {
        return dc(s.toCharArray(), 0, s.length() - 1, k);
    }

    private int dc(char[] chs, int s, int e, int k) {
        if (e - s + 1 < k) return 0;

        int[] cnt = new int[26];
        for (int i = s; i <= e; i++) {
            cnt[chs[i] - 'a']++;
        }

        // iterate through letters will cause less time!!!
        // if iterate through original string, repeating letters could cause more time
        for (int i = 0; i < 26; i++) {
            if (cnt[i] == 0) continue;
            else if (cnt[i] < k) {
                for (int j = s; j <= e; j++) {
                    if (i + 'a' == chs[j]) {
                        return Math.max(dc(chs, s, j - 1, k), dc(chs, j + 1, e, k)); 
                    }
                }
            }
        }

        return e - s + 1;
    }
}