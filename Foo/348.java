public class TicTacToe {

    private int[][] board;
    private int n;

    /** Initialize your data structure here. */
    public TicTacToe(int n) {
        board = new int[n][n];
        this.n = n;
    }
    
    /** Player {player} makes a move at ({row}, {col}).
        @param row The row of the board.
        @param col The column of the board.
        @param player The player, can be either 1 or 2.
        @return The current winning condition, can be either:
                0: No one wins.
                1: Player 1 wins.
                2: Player 2 wins. */
    public int move(int row, int col, int player) {
        board[row][col] = player;
        if (win(row, col, player)) return player;
        return 0;
    }

    private boolean win(int row, int col, int player) {
        boolean allPlayerRow = true;
        boolean allPlayerCol = true;
        for (int i = 0; i < n; i++) {
            if (board[row][i] != player) allPlayerRow = false;
            if (board[i][col] != player) allPlayerCol = false;
        }
        if (allPlayerCol || allPlayerRow) return true;

        if (row == col) {
            boolean allDiag = true;
            for (int i = 0; i < n; i++) {
                if (board[i][i] != player) allDiag = false;
            }
            if (allDiag) return true;
        }

        if (row + col == n - 1) {
            boolean allDiag = true;
            for (int i = 0; i < n; i++) {
                if (board[i][n - 1 - i] != player) allDiag = false;
            }
            if (allDiag) return true;
        }

        return false;
    }
}

/**
 * Your TicTacToe object will be instantiated and called as such:
 * TicTacToe obj = new TicTacToe(n);
 * int param_1 = obj.move(row,col,player);
 */