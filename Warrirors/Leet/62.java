public class Solution {
    public int uniquePaths(int m, int n) {
        if (m == 1 || n == 1) return 1;
        int[][] mem = new int[m][n];
        for (int i = 0; i < m; i++) {
            mem[i][0] = 1;
        }
        for (int i = 0; i < n; i++) {
            mem[0][i] = 1;
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                mem[i][j] = mem[i-1][j] + mem[i][j-1];
            }
        }

        return mem[m-1][n-1];
    }
}

// Math method (m+n)! / m!*n!
public class Solution {
    public int uniquePaths(int m, int n) {
        if (m == 1 || n == 1) return 1;
        m--;
        n--;

        // to boost performance, less number of loops
        if (m < n) {
            int tmp = n;
            n = m;
            m = tmp;
        }

        long res = 1;
        for (int i = m + 1, j = 1; i <= m + n; i++, j++) {
            res *= i;
            res /= j;
        }

        return (int)res;
    }
}
