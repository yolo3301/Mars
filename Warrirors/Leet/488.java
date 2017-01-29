public class Solution {
    public int findMinStep(String board, String hand) {
        String sorted = new String(Arrays.sort(hand.toCharArray()));
        int res = bt(board, sorted);
        return (res > hand.length()) ? -1: res;
    }

    private int bt(String board, String hand) {
        board = shrink(board);
        if (board.length() == 0) return 0;        
        if (hand.length() == 0) return 10;

        int i = 0, min = 10;
        while (i < board.length()) {
            int j = i;
            while (j < board.length() && board.charAt(j) == board.charAt(i)) {
                j++;
            }

            int cnt = j - i;
            int startIndex = hand.indexOf(board.charAt(i));
            int more = cnt(hand, startIndex);
            if (more > 2 - cnt) {
                String nb = board.substring(0, i) + board.substring(j);
                String nh = hand.substring(0, startIndex) + hand.substring(startIndex + 3 - cnt);
                min = Math.min(min, bt(nb, nh) + 3 - cnt);
            }

            i = j;
        }

        return min;
    }

    private int cnt(String hand, int startIndex) {
        if (startIndex < 0 || startIndex >= hand.length()) return 0;
        int j = startIndex;
        while (j < hand.length() && hand.charAt(j) == hand.charAt(startIndex)) {
            j++;
        }

        return j - startIndex;
    }

    private String shrink(String str) {
        if (str.length() == 0) return str;
        boolean doAnything = false;
        do {
            doAnything = false;
            int i = 0, len = str.length();
            while (i < len) {
                char curr = str.charAt(i);
                int cnt = 1, j = i + 1;
                while (j < str.length() && str.charAt(j) == curr) {
                    j++;
                    cnt++;
                }

                if (cnt >= 3) {
                    str = str.substring(0, i) + str.substring(j);
                    len = str.length();
                    doAnything = true;
                } else {
                    i = j;
                }
            }
        } while (doAnything);

        return str;
    }
}