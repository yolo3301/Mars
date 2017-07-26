public class Solution {
    public int countSubstrings(String s) {
        int res = 0;
        boolean[][] isPan = new boolean[s.length()][s.length()];

        for (int i = 0; i < s.length(); i++) {
            isPan[i][i] = true;
            res++;
            for (int j = i-1; j >= 0; j--) {
                if (s.charAt(i) == s.charAt(j) && (i == j+1 || isPan[j+1][i-1])) {
                    isPan[j][i] = true;
                    res++;
                }
            }
        }

        return res;
    }
}