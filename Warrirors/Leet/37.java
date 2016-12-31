public class Solution {
    public void solveSudoku(char[][] board) {
        boolean[][] row = new boolean[9][9];
        boolean[][] col = new boolean[9][9];
        boolean[][] block = new boolean[9][9];

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char curr = board[i][j];
                if (curr != '.') {
                    row[i][curr - '1'] = true;
                    col[j][curr - '1'] = true;
                    block[i / 3 * 3 + j / 3][curr - '1'] = true;
                }
            }
        }

        find(board, 0, 0, row, col, block);
    }

    private boolean find(char[][] board, int x, int y, boolean[][] row, boolean[][] col, boolean[][] block) {
        if (x == 9) return true;

        if (board[x][y] != '.') {
            if (y == 8) {
                if (find(board, x + 1, 0, row, col, block)) return true;
            } else if (find(board, x, y + 1, row, col, block)) {
                return true;
            }
        } else {
            for (int i = 1; i <= 9; i++) {
                if (!row[x][i-1] && !col[y][i-1] && !block[x / 3 * 3 + y / 3][i-1]) {
                    row[x][i-1] = true;
                    col[y][i-1] = true;
                    block[x / 3 * 3 + y / 3][i-1] = true;
                    board[x][y] = (char)('0' + i);
                    if (y == 8) {
                        if (find(board, x + 1, 0, row, col, block)) return true;
                    } else if (find(board, x, y + 1, row, col, block)) {
                        return true;
                    }
                    row[x][i-1] = false;
                    col[y][i-1] = false;
                    block[x / 3 * 3 + y / 3][i-1] = false;
                }
            }
            board[x][y] = '.';
        }

        return false;
    }
}
