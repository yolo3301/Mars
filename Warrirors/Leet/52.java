public class Solution {
    private int count = 0;
    public int totalNQueens(int n) {
        char[][] m = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                m[i][j] = '.';
            }
        }
        bt(n, 0, m);
        return count;
    }

    private void bt(int n, int index, char[][] m) {
        if (index == n) {
            count++;
            return;
        }

        for (int i = 0; i < n; i++) {
            boolean go = true;
            for (int j = 1; index - j >= 0; j++) {
                if (m[index - j][i] == 'Q') {
                    go = false;
                    break;
                }
            }
            if (go) {
                for (int j = 1; i - j >= 0 && index - j >= 0; j++) {
                    if (m[index - j][i - j] == 'Q') {
                        go = false;
                        break;
                    }
                }
            }
            if (go) {
                for (int j = 1; i + j < n && index - j >= 0; j++) {
                    if (m[index - j][i + j] == 'Q') {
                        go = false;
                        break;
                    }
                }
            }

            if (go) {
                m[index][i] = 'Q';
                bt(n, index + 1, m);
                m[index][i] = '.';
            }
        }
    }
}
