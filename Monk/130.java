public class Solution {
    int m, n;

    public void solve(char[][] board) {
        m = board.length;
        if (m == 0) return;
        n = board[0].length;
        if (n == 0) return;

        for (int i = 0; i < n; i++) {
            fill(board, new int[]{0, i});
            fill(board, new int[]{m-1, i});
        }

        for (int i = 1; i < m-1; i++) {
            fill(board, new int[]{i, 0});
            fill(board, new int[]{i, n-1});
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'T') board[i][j] = 'O';
                else if (board[i][j] == 'O') board[i][j] = 'X';
            }
        }
    }

    private void fill(char[][] board, int[] start) {
        if (board[start[0]][start[1]] != 'O') return;
        Queue<int[]> q = new LinkedList<>();
        q.add(start);
        board[start[0]][start[1]] = 'T';

        while(!q.isEmpty()) {
            int[] curr = q.remove();
            if (toAdd(board, curr[0]-1, curr[1])) q.add(new int[]{curr[0]-1, curr[1]});
            if (toAdd(board, curr[0]+1, curr[1])) q.add(new int[]{curr[0]+1, curr[1]});
            if (toAdd(board, curr[0], curr[1]-1)) q.add(new int[]{curr[0], curr[1]-1});
            if (toAdd(board, curr[0], curr[1]+1)) q.add(new int[]{curr[0], curr[1]+1});
        }
    }

    private boolean toAdd(char[][] board, int x, int y) {
        if (x < 0 || x >= m) return false;
        if (y < 0 || y >= n) return false;
        if (board[x][y] == 'O') {
            board[x][y] = 'T';
            return true;
        }
        return false;
    }
}