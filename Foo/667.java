class Solution {
    public int[] constructArray(int n, int k) {
        int[] res = new int[n];

        if (k == 1) {
            for (int i = 1; i <= n; i++) {
                res[i-1] = i;
            }
            return res;
        }

        if (k == n-1) {
            int a = n, b = 1;
            for (int i = 0; i < n; ) {
                res[i++] = a--;
                if (i < n) {
                    res[i++] = b++;
                }
            }
            return res;
        }

        int a = n, b = 1, c = (k%2 == 0) ? k : k-1;
        for (int i = 0; i < c; ) {
            res[i++] = a--;
            if (i < c) {
                res[i++] = b++;
            }
        }
        for (int i = c; i < n; i++) {
            res[i] = b++;
        }

        if (k % 2 != 0) {
            int tmp = res[c-1];
            res[c-1] = res[c];
            res[c] = tmp;
        }

        return res;
    }
}