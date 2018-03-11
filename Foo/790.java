class Solution {
    public int numTilings(int N) {
        int M = 1000000007;
        int[] p = new int[3];
        p[0] = 1;
        p[1] = 2;
        p[2] = 5;
        
        if (N <= 3) return p[N-1];
        
        for (int i = 3; i < N; i++) {
            int cur = ((2 * p[2]) % M + p[0]) % M;
            p[0] = p[1];
            p[1] = p[2];
            p[2] = cur;
        }

        return p[2];
    }
}