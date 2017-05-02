public class Solution {
    public String getPermutation(int n, int k) {
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            sb.append(i);
        }

        return helper(sb.toString(), k);
    }

    private String helper(String s, int k) {
        if (k == 1) return s;

        int cnt = 1, upAcc = 1;
        for (cnt = 1; cnt <= s.length(); cnt++) {
            upAcc *= cnt;
            if (upAcc >= k) break;
        }

        int lowAcc = upAcc / cnt;
        int numOfK = (k-1) / lowAcc - 1;
        int modOfK = (k-1) % lowAcc + 1;

        char replace = s.charAt(s.length() - cnt);
        char[] next = s.substring(s.length() - cnt + 1).toCharArray();
        
        StringBuilder sb = new StringBuilder();
        sb.append(s.substring(0, s.length() - cnt));
        sb.append(next[numOfK]);

        for (int j = 0; j <= numOfK; j++) {
            char tmp = next[j];
            next[j] = replace;
            replace = tmp;
        }

        sb.append(helper(new String(next), modOfK));
        return sb.toString();
    }
}