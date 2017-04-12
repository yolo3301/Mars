public class Solution {
    public char[][] updateBoard(char[][] board, int[] click) {
        int x = click[0];
        int y = click[1];

        if (board[x][y] == 'M') {
            board[x][y] = 'X';
            return board;
        }

        explore(board, x, y);
        return board;
    }

    private void explore(char[][] board, int x, int y) {
        if (x >= board.length || x < 0 || y >= board[0].length || y < 0)
            return;

        if (board[x][y] == 'E') {
            int adMines = adjacentMines(board, x, y);
            if (adMines > 0) board[x][y] = (char)('0' + adMines);
            else {
                board[x][y] = 'B';
                explore(board, x+1, y);
                explore(board, x-1, y);
                explore(board, x, y-1);
                explore(board, x, y+1);
                explore(board, x-1, y-1);
                explore(board, x-1, y+1);
                explore(board, x+1, y-1);
                explore(board, x+1, y+1);
            }
        }
    }

    private int adjacentMines(char[][] board, int x, int y) {
        int res = 0;
        if (x-1 >= 0 && board[x-1][y] == 'M') res++; 
        if (x+1 < board.length && board[x+1][y] == 'M') res++; 
        if (y-1 >= 0 && board[x][y-1] == 'M') res++; 
        if (y+1 < board[0].length && board[x][y+1] == 'M') res++; 
        if (x-1 >= 0 && y-1 >= 0 && board[x-1][y-1] == 'M') res++; 
        if (x-1 >= 0 && y+1 < board[0].length && board[x-1][y+1] == 'M') res++; 
        if (x+1 < board.length && y-1 >= 0 && board[x+1][y-1] == 'M') res++; 
        if (x+1 < board.length && y+1 < board[0].length && board[x+1][y+1] == 'M') res++; 

        return res;
    }
}