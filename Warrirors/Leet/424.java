public class Solution {
    public int characterReplacement(String s, int k) {
        if (k >= s.length()) return s.length();
        int max = 0;
        for (char c = 'A'; c <= 'Z'; c++) {
            max = Math.max(max, cal(s.toCharArray(), k, c));
        }
        return max;
    }

    private int cal(char[] chs, int k, char target) {
        int len = chs.length;
        int[][] mem = new int[len][k+1];
        int max = k > 0 ? 1 : 0;
        mem[0][0] = chs[0] == target ? 1 : 0;
        if (k > 0) mem[0][1] = 1;

        for (int i = 1; i < len; i++) {
            int lim = Math.min(i + 1, k);
            for (int j = 0; j <= lim; j++) {
                if (chs[i] == target) {
                    mem[i][j] = mem[i-1][j] + 1;
                } else {
                    if (j == 0) {
                        mem[i][j] = 0;
                    } else {
                        mem[i][j] = mem[i-1][j-1] + 1;
                    }
                }
                max = Math.max(max, mem[i][j]);
            }
        }

        return max;
    }
}

public class Solution {
    public int characterReplacement(String s, int k) {
        int[] count = new int[26];
        int start = 0, maxCount = 0, res = 0;
        for (int end = 0; end < s.length(); end++) {
            maxCount = Math.max(maxCount, ++count[s.charAt(end) - 'A']);
            if (end - start + 1 - maxCount > k) {
                count[s.charAt(start++) - 'A']--;
            }
            res = Math.max(res, end - start + 1);
        }
        return res;
    }
}
