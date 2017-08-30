class Solution {
    public int findKthNumber(int m, int n, int k) {
        int l = 1, r = m*n + 1;
        while (l < r) {
            int mid = l + (r - l) / 2;
            int cnt = count(mid, m, n);
            if (cnt >= k) {
                r = mid;
            } else {
                l = mid+1;
            }
        }

        return r;
    }

    private int count(int v, int m, int n) {
        int cnt = 0;
        for (int i = 1; i <= m; i++) {
            int tmp = Math.min(n, v / i); // how many elements can take in row i
            if (tmp == 0) break;
            cnt += tmp;
        }
        return cnt;
    }
}