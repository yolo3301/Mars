public class Solution {
    public String getPermutation(int n, int k) {
        if (n == 1) return "1";

        char[] chs = new char[n];
        for (int i = 1; i <= n; i++) chs[i-1] = (char)('0' + i);

        helper(chs, 0, chs.length - 1, k);

        return new String(chs);
    }

    private void helper(char[] chs, int s, int e, int k) {
        Arrays.sort(chs, s, e + 1);
        if (k == 1) {
            return;
        }

        int cnt = 1;
        int f = 1;
        while (k > f) {
            cnt++;
            f *= cnt;
        }

        if (f == k) {
            reverse(chs, e - cnt + 1, e);
            return;
        }

        int i = (k - 1) / (f / cnt);
        int j = (k - 1) % (f / cnt) + 1;

        swap(chs, e - cnt + 1, e - cnt + 1 + i);
        helper(chs, e - cnt + 2, e, j);
    }

    private void swap(char[] chs, int i, int j) {
        char t = chs[i];
        chs[i] = chs[j];
        chs[j] = t;
    }

    private void reverse(char[] chs, int s, int e) {
        for (int i = 0; i <= (e - s) / 2; i++) {
            swap(chs, s + i, e - i);
        }
    }
}