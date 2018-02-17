class Solution {
    public int movesToChessboard(int[][] board) {
        int N = board.length;
        int rowSum = 0, colSum = 0, rowSwap = 0, colSwap = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if ((board[0][0] ^ board[0][j] ^ board[i][0] ^ board[i][j]) == 1)
                    return -1;
            }
        }

        for (int i = 0; i < N; i++) {
            rowSum += board[0][i];
            colSum += board[i][0];
            // Suppose 0 on even indices
            if (board[i][0] == i % 2) rowSwap++;
            if (board[0][i] == i % 2) colSwap++;
        }

        // # of 1s can't too much or too little
        if (N/2 > rowSum || rowSum > N/2 + N%2) return -1;
        if (N/2 > colSum || colSum > N/2 + N%2) return -1;

        if (N%2 == 1) {
            if (colSwap % 2 == 1) colSwap = N - colSwap;
            if (rowSwap % 2 == 1) rowSwap = N - rowSwap;
        } else {
            colSwap = Math.min(colSwap, N - colSwap);
            rowSwap = Math.min(rowSwap, N - rowSwap);
        }

        return (colSwap + rowSwap) / 2;
    }
}