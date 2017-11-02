class Solution {
    public void gameOfLife(int[][] board) {
        int m = board.length;
        if (m == 0) return;
        int n = board[0].length;
        if (n == 0) return;

        int[][] dirs = new int[][]{
            {0,1},{0,-1},{1,0},{-1,0},
            {1,1},{1,-1},{-1,1},{-1,-1}
        };

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int live = 0;
                for (int[] d : dirs) {
                    int x = i+d[0];
                    int y = j+d[1];
                    if (x >= 0 && x < m && y >= 0 && y < n) {
                        if (board[x][y] % 2 == 1) live++;
                    }
                }
                if (live < 2 && board[i][j] == 1) board[i][j] = 3;
                if (live == 3 && board[i][j] == 0) board[i][j] = 2;
                if (live > 3 && board[i][j] == 1) board[i][j] = 3;
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 1 || board[i][j] == 2) board[i][j] = 1;
                else board[i][j] = 0;
            }
        }
    }
}
