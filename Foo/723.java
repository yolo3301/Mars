class Solution {
    public int[][] candyCrush(int[][] board) {
        int m = board.length;
        int n = board[0].length;
        int[][] state = new int[m][n];

        while (crush(board, state)) {
            rearrange(board);
        }

        return board;
    }

    private void resetState(int[][] state) {
        for (int i = 0; i < state.length; i++) {
            Arrays.fill(state[i], 0);
        }
    }

    private void rearrange(int[][] board) {
        int m = board.length;
        int n = board[0].length;

        for (int j = 0; j < n; j++) {
            int k = m-1;
            for (int i = m-1; i >= 0; i--) {
                if (board[i][j] != 0) {
                    int tmp = board[k][j];
                    board[k][j] = board[i][j];
                    board[i][j] = tmp;
                    k--;
                }
            }
        }
    }

    private boolean crush(int[][] board, int[][] state) {
        boolean ret = false;
        resetState(state);

        int m = board.length;
        int n = board[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (state[i][j] == 3 || board[i][j] == 0) continue;
                if (state[i][j] != 1) {
                    int cnt = 1;
                    for (int k = j+1; k < n; k++) {
                        if (board[i][k] == board[i][j]) cnt++;
                        else break;
                    }
                    for (int k = j-1; k >= 0; k--) {
                        if (board[i][k] == board[i][j]) cnt++;
                        else break;
                    }
                    if (cnt >= 3) {
                        ret = true;
                        //System.out.println("Erase H: " + board[i][j] + "  " + i + " " + j);
                        state[i][j] |= 1;
                        for (int k = j+1; k < n; k++) {
                            if (board[i][k] == board[i][j]) state[i][k] |= 1;
                            else break;
                        }
                        for (int k = j-1; k >= 0; k--) {
                            if (board[i][k] == board[i][j]) state[i][k] |= 1;
                            else break;
                        }
                    }
                }
                if (state[i][j] != 2) {
                    int cnt = 1;
                    for (int k = i+1; k < m; k++) {
                        if (board[k][j] == board[i][j]) cnt++;
                        else break;
                    }
                    for (int k = i-1; k >= 0; k--) {
                        if (board[k][j] == board[i][j]) cnt++;
                        else break;
                    }
                    if (cnt >= 3) {
                        ret = true;
                        //System.out.println("Erase V: " + board[i][j] + "  " + i + " " + j);
                        state[i][j] |= 2;
                        for (int k = i+1; k < m; k++) {
                            if (board[k][j] == board[i][j]) state[k][j] |= 2;
                            else break;
                        }
                        for (int k = i-1; k >= 0; k--) {
                            if (board[k][j] == board[i][j]) state[k][j] |= 2;
                            else break;
                        }
                    }
                }
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (state[i][j] != 0 && board[i][j] != 0) board[i][j] = 0;
            }
        }

        return ret;
    }
}

