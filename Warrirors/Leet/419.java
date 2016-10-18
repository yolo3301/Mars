// # flood fill

public class Solution {
    public int countBattleships(char[][] board) {
        int m = board.length;
        int n = board[0].length;
        int count = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'X') {
                    int k = j;
                    while (k < n && board[i][k] == 'X') {
                        board[i][k++] = '$';
                    }
                    k = i + 1;
                    while (k < m && board[k][j] == 'X') {
                        board[k++][j] = '$';
                    }
                    count++;
                }
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == '$') {
                    board[i][j] = 'X';
                }
            }
        }

        return count;
    }
}
