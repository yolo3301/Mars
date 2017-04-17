public class Solution {
    public String getPermutation(int n, int k) {
        int max = max(n);
        if (k > max) k %= max;

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            sb.append(i);
        }
        String res = sb.toString();

        return sub(res, k);
    }

    private String sub(String s, int k) {
        if (k == 1) return s;

        int cnt = 1, upAcc = 1;
        for (cnt = 1; cnt <= s.length(); cnt++) {
            upAcc *= cnt;
            if (k <= upAcc) break;
        }

        int lowAcc = upAcc / cnt;
        int numOfK = (k - 1) / lowAcc - 1;
        int modOfK = (k - 1) % lowAcc + 1;

        char replace = s.charAt(s.length() - cnt);
        int toReplace = 0;
        char[] next = s.substring(s.length() - cnt + 1).toCharArray();

        StringBuilder sb = new StringBuilder();
        sb.append(s.substring(0, s.length() - cnt));
        sb.append(next[numOfK]);

        for (toReplace = 0; toReplace <= numOfK; toReplace++) {
            char tmp = next[toReplace];
            next[toReplace] = replace;
            replace = tmp;
        }
        sb.append(sub(new String(next), modOfK));

        return sb.toString();
    }

    private int max(int n) {
        int acc = 1;
        for (int i = 1; i <= n; i++) acc *= i;
        return acc;
    }
}