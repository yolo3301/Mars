// I can't even understand myself!!!
public class Solution {
    public String getPermutation(int n, int k) {
        char[] chs = new char[n];
        for (int i = 1; i <= n; i++) {
            chs[i-1] = (char)('0' + i);
        }
        return sub(chs, k);
    }

    private String sub(char[] chs, int k) {
        if (k == 1) return new String(chs);

        int x = 1;
        int c = 0;
        int pre = 1;
        while (k > x) {
            pre = x;
            x *= (c + 1);
            c++;
        }

        x = pre;
        c--;
        int y = (k - x) / x;
        int z = (k - x) % x;
        if (z == 0) y--;

        char[] copy = Arrays.copyOfRange(chs, chs.length - c, chs.length);
        Arrays.sort(copy);
        if (c < chs.length) {
            char cand = chs[chs.length - c - 1];
            chs[chs.length - c - 1] = copy[y];
            for (int j = y; j > 0; j--) {
                copy[j] = copy[j - 1];
            }
            copy[0] = cand;
        }

        if (z == 0) {
            for (int j = 0; j < copy.length; j++) {
                chs[chs.length - 1 - j] = copy[j];
            }
        } else {
            String next = sub(copy, z);
            for (int j = 0; j < next.length(); j++) {
                chs[chs.length - 1 - j] = next.charAt(next.length() - 1 - j);
            }
        }

        return new String(chs);
    }
}
