public class Solution {
    public int findMinStep(String board, String hand) {
        char[] h = hand.toCharArray();
        Arrays.sort(h);
        int res = bt(board, new String(h));
        if (res == 10) return -1;
        return res;
    }

    private int bt(String board, String hand) {
        board = shrink(board);
        if (board.length() == 0) return 0;
        if (hand.length() == 0) return 10;

        int res = 10;
        for (int i = 0; i < board.length(); ) {
            int j = i;
            while (j < board.length() && board.charAt(i) == board.charAt(j)) {
                j++;
            }

            int cnt = j - i;
            int startIndex = hand.indexOf(board.charAt(i));
            int has = cntFreq(hand, startIndex);

            if (startIndex != -1 && has + cnt >= 3) {
                int curr = (3-cnt) + bt(board.substring(0, i)+board.substring(j), hand.substring(0, startIndex)+hand.substring(startIndex+3-cnt));
                res = Math.min(res, curr);
            }

            i = j;
        }

        return res;
    }

    private int cntFreq(String s, int startIndex) {
        if (startIndex == -1) return 0;
        int res = 0;
        for (int i = startIndex; i < s.length() && s.charAt(i) == s.charAt(startIndex); i++) {
            res++;
        }

        return res;
    }

    private String shrink(String board) {
        boolean action = false;
        do {
            action = false;
            int i = 0;
            while (i < board.length()) {
                int j = i;
                while (j < board.length() && board.charAt(i) == board.charAt(j)) {
                    j++;
                }

                if (j - i >= 3) {
                    board = board.substring(0, i)+board.substring(j);
                    action = true;
                } else {
                    i = j;
                }
            }
        } while (action);

        return board;
    }
}