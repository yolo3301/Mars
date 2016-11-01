public class Solution {
    public int longestSubstring(String s, int k) {
        return helper(s.toCharArray(), 0, s.length(), k);
    }

    // divide and conquer
    // the "divide idea" -- if a char appears less than K, then the string can be divided into 2
    // O(nlogn) time
    private int helper(char[] chs, int s, int e, int k) {
        if (e - s < k) return 0;
        int[] count = new int[26];
        for (int i = s; i < e; i++) {
            count[chs[i] - 'a']++;
        }

        for (int i = 0; i < 26; i++) {
            if (count[i] == 0) continue;
            else if (count[i] < k) {
                for (int j = s; j < e; j++) {
                    if (chs[j] == i + 'a') {
                        return Math.max(helper(chs, s, j, k), helper(chs, j+1, e, k));
                    }
                }
            }
        }

        return e - s;
    }
}
