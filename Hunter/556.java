public class Solution {
    public int nextGreaterElement(int n) {
        char[] chs = Integer.toString(n).toCharArray();
        int i = chs.length - 1;
        while (i > 0 && chs[i-1] >= chs[i]) i--;

        if (i == 0) return -1;

        i--;
        int j = chs.length - 1;
        while (j > i && chs[j] <= chs[i]) j--;

        swap(chs, i, j);
        reverse(chs, i+1, chs.length-1);

        long res = Long.parseLong(new String(chs));
        if (res > Integer.MAX_VALUE) return -1;
        else return (int)res;
    }

    private void reverse(char[] chs, int i, int j) {
        for (int k = 0; k <= (j - i) / 2; k++) {
            swap(chs, i+k, j-k);
        }
    }

    private void swap(char[] chs, int i, int j) {
        char tmp = chs[i];
        chs[i] = chs[j];
        chs[j] = tmp;
    }
}