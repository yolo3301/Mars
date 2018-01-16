class Solution {
    public int orderOfLargestPlusSign(int N, int[][] mines) {
        int[][] mat = new int[N][N];
        for (int[] m : mines) {
            mat[m[0]][m[1]] = 1;
        }

        int[][][] memo = prepare(N, mat);

        int ret = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (mat[i][j] == 1) continue;
                ret = Math.max(ret, findMax(memo[i][j]));
            }
        }
        
        return ret;
    }

    private int findMax(int[] len) {
        return Math.min(len[0], Math.min(len[1], Math.min(len[2], len[3]))) + 1;
    }

    private int[][][] prepare(int N, int[][] mat) {
        int[][][] memo = new int[N][N][4];
        int[] sum = new int[N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                memo[i][j][0] = sum[j];
                if (mat[i][j] == 0) sum[j]++;
                else sum[j] = 0;
            }
        }

        Arrays.fill(sum, 0);
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                memo[j][i][2] = sum[j];
                if (mat[j][i] == 0) sum[j]++;
                else sum[j] = 0;
            }
        }

        Arrays.fill(sum, 0);
        for (int i = N-1; i >= 0; i--) {
            for (int j = N-1; j >= 0; j--) {
                memo[i][j][1] = sum[j];
                if (mat[i][j] == 0) sum[j]++;
                else sum[j] = 0;
            }
        }

        Arrays.fill(sum, 0);
        for (int i = N-1; i >= 0; i--) {
            for (int j = N-1; j >= 0; j--) {
                memo[j][i][3] = sum[j];
                if (mat[j][i] == 0) sum[j]++;
                else sum[j] = 0;
            }
        }

        return memo;
    }
}