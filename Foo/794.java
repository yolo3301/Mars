class Solution {
    public boolean validTicTacToe(String[] board) {
        int c1 = 0, c2 = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i].charAt(j) == 'X') c1++;
                if (board[i].charAt(j) == 'O') c2++;
            }
        }

        if (c2 > c1) return false;
        if (c1 - c2 > 1) return false;

        if (win(board, 'X') && (win(board, 'O') || c1 == c2))
            return false;
        
        if (win(board, 'O') && c1 > c2) return false;

        return true;
    }

    private boolean win(String[] board, char target) {
        boolean ret = true;

        for (int i = 0; i < 3; i++) {
            ret = true;
            for (int j = 0; j < 3; j++) {
                if (board[i].charAt(j) != target) {
                    ret = false;
                    break;
                }
            }

            if (ret) return true;
        }

        for (int i = 0; i < 3; i++) {
            ret = true;
            for (int j = 0; j < 3; j++) {
                if (board[j].charAt(i) != target) {
                    ret = false;
                    break;
                }
            }

            if (ret) return true;
        }

        ret = true;
        for (int i = 0; i < 3; i++) {
            if (board[i].charAt(i) != target) {
                ret = false;
                break;
            }
        }

        if (ret) return true;

        ret = true;
        for (int i = 0; i < 3; i++) {
            if (board[i].charAt(2-i) != target) {
                ret = false;
                break;
            }
        }

        if (ret) return true;

        return false;
    }
}