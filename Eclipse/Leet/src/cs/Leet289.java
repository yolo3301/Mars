package cs;

public class Leet289 {
	public void gameOfLife(int[][] board) {
        int m = board.length, n = board[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = next(board, i, j);
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 3) board[i][j] = 1;
                else if (board[i][j] == 4) board[i][j] = 0;
            }
        }
    }

    private int next(int[][] board, int x, int y) {
        int m = board.length, n = board[0].length;
        int numOfLive = 0;
        System.out.println(x + ":" + y);
        if (x - 1 >= 0) {
            numOfLive += cal(board[x-1][y]);
            System.out.println("(1)" + numOfLive);
            if (y - 1 >= 0) numOfLive += cal(board[x-1][y-1]);
            System.out.println("(2)" + numOfLive);
            if (y + 1 < n) numOfLive += cal(board[x-1][y+1]);
            System.out.println("(3)" + numOfLive);
        }
        if (x + 1 < m) {
            numOfLive += cal(board[x+1][y]);
            System.out.println("(4)" + numOfLive);
            if (y - 1 >= 0) numOfLive += cal(board[x+1][y-1]);
            System.out.println("(5)" + numOfLive);
            if (y + 1 < n) numOfLive += cal(board[x+1][y+1]);
            System.out.println("(6)" + numOfLive);
        }

        if (y - 1 >= 0) numOfLive += cal(board[x][y-1]);
        System.out.println("(7)" + numOfLive);
        if (y + 1 < n) numOfLive += cal(board[x][y+1]);
        System.out.println("(8)" + numOfLive);

        if (board[x][y] == 1 && (numOfLive < 2 || numOfLive > 3)) return 4;
        if (numOfLive == 3 && board[x][y] == 0) return 3;
        return board[x][y];
    }

    // 3 means go live (0 -> 1)
    // 4 means go dead (1 -> 0)
    private int cal(int z) {
        if (z == 1 || z == 4) return 1;
        return 0;
    }
}
