public class Solution {
    public boolean isValidSudoku(char[][] board) {
        int[][] column = new int[9][9];
        int[][] row = new int[9][9];
        int[][] block = new int[9][9];

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                    if (board[i][j] != '.') {
                    int curr = board[i][j] - '0' - 1;
                    if (column[j][curr] == 1) return false;
                    else column[j][curr] = 1;
                    if (row[i][curr] == 1) return false;
                    else row[i][curr] = 1;
                    if (block[findBlock(i, j)][curr] == 1) return false;
                    else block[findBlock(i, j)][curr] = 1;
                }
            }
        }

        return true;
    }

    private int findBlock(int x, int y) {
        if (x <= 2 && y <= 2) return 0;
        if (x <= 2 && y > 2 && y <= 5) return 3;
        if (x <=2 && y > 5) return 6;
        if (x > 2 && x <= 5 && y <= 2) return 1;
        if (x > 5 && y <= 2) return 2;
        if (x > 2 && x <= 5 && y > 2 && y <= 5) return 4;
        if (x > 2 && x <= 5 && y > 5) return 5;
        if (x > 5 && y > 2 && y <= 5) return 7;
        if (x > 5 && y > 5) return 8;

        return -1;
    }
}
