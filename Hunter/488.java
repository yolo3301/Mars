public class Solution {
    public int findMinStep(String board, String hand) {
        char[] h = hand.toCharArray();
        Arrays.sort(h);
        int res = bt(board, new String(h));
        if (res > hand.length()) return -1;
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

            int len = j - i;
            int start = hand.indexOf(board.charAt(i));
            int inhand = count(hand, start);

            if (inhand >= 3 - len) {
                int a = 3-len;
                res = Math.min(res, a + bt(board.substring(0, i)+board.substring(j), hand.substring(0, start)+hand.substring(start+a)));
            }
            
            i = j;
        }

        return res;
    }

    private int count(String hand, int start) {
        if (start == -1) return 0;
        int i = start;
        while(i < hand.length() && hand.charAt(i) == hand.charAt(start)) {
            i++;
        }

        return i - start;
    }

    private String shrink(String board) {
        if (board.length() == 0) return "";
        boolean removed = false;
        do {
            removed = false;
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < board.length(); ) {
                int j = i;
                while (j < board.length() && board.charAt(i) == board.charAt(j)) {
                    j++;
                }
                if (j - i < 3) {
                    while (i < j) sb.append(board.charAt(i++));
                } else {
                    removed = true;
                    i = j;
                }
            }
            board = sb.toString();
        } while (removed);

        return board;
    }
}