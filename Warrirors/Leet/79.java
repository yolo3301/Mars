public class Solution {
    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (search(board, word, 0, i, j, m, n)) return true;
            }
        }

        return false;
    }

    private boolean search(char[][] board, String word, int index, int x, int y, int m, int n) {
        if (index == word.length()) {
            return true;
        }

        if (x >= m || x < 0 || y >= n || y < 0) return false;
        if (board[x][y] != word.charAt(index)) return false;

        board[x][y] ^= 256;
        // board[x][y] = '*'

        boolean res = search(board, word, index + 1, x + 1, y, m, n)
                    || search(board, word, index + 1, x - 1, y, m, n)
                    || search(board, word, index + 1, x, y + 1, m, n)
                    || search(board, word, index + 1, x, y - 1, m, n);

        board[x][y] ^= 256;
        // board[x][y] = word.charAt(index)

        return res;
    }
}
