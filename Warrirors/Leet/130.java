public class Solution {
    public void solve(char[][] board) {
        int m = board.length;
        if (m == 0) return;
        int n = board[0].length;
        if (m < 2 || n < 2) return;

        for (int i = 0; i < m; i++) {
            if (board[i][0] == 'O')
                fill(board, i, 0, m ,n);
            if (board[i][n-1] == 'O')
                fill(board, i, n - 1, m, n);
        }

        for (int i = 0; i < n; i++) {
            if (board[0][i] == 'O')
                fill(board, 0, i, m ,n);
            if (board[m-1][i] == 'O')
                fill(board, m - 1, i, m, n);
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'O')
                    board[i][j] = 'X';
                else if (board[i][j] == 'Z')
                    board[i][j] = 'O';
            }
        }
    }

    // Tricky here to reduce recursive calls
    // to avoid stack overflow
    private void fill(char[][] board, int x, int y, int m, int n) {
        if (x >= m || x < 0 || y >= n || y < 0) return;
        if (board[x][y] == 'O')
            board[x][y] = 'Z';
        // Don't call in for boarders
        if (x + 1 < m - 1 && board[x+1][y] == 'O')
            fill(board, x+1, y, m, n);
        if (x - 1 > 0 && board[x-1][y] == 'O')
            fill(board, x-1, y, m, n);
        if (y + 1 < n - 1 && board[x][y+1] == 'O')
            fill(board, x, y+1, m, n);
        if (y - 1 > 0 && board[x][y-1] == 'O')
            fill(board, x, y-1, m, n);
    }
}
