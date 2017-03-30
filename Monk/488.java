public class Solution {
    public int findMinStep(String board, String hand) {
        char[] h = hand.toCharArray();
        Arrays.sort(h);
        int res = bt(board, new String(h));
        if (res > hand.length()) return -1;
        else return res;
    }

    private int bt(String board, String hand) {
        board = shrink(board);
        if (board.length() == 0) return 0;
        if (hand.length() == 0) return 10;

        int res = 10;
        for (int i = 0; i < board.length(); ) {
            int j = i;
            while (j < board.length() && board.charAt(j) == board.charAt(i)) {
                j++;
            }

            int len = j - i;
            int start = hand.indexOf(board.charAt(i));
            int more = count(hand, start);

            if (more >= 3 - len) {
                res = Math.min(res, (3-len>0?3-len:0)+bt(board.substring(0, i)+board.substring(j),
                    hand.substring(0, start)+hand.substring(start+(3-len>0?3-len:0))));
            }
            
            i = j;
        }

        return res;
    }

    private int count(String hand, int start) {
        if (start == -1) return 0;

        int j = start;
        while (j < hand.length() && hand.charAt(j) == hand.charAt(start)) j++;

        return j - start;
    }

    private String shrink(String s) {
        if (s.length() == 0) return s;
        boolean doSomething = false;
        do {
            doSomething = false;
            int i = 0, len = s.length();
            while (i < len) {
                int j = i;
                while (j < len && s.charAt(j) == s.charAt(i)) j++;

                if (j - i >= 3) {
                    s = s.substring(0, i) + s.substring(j);
                    len = s.length();
                    doSomething = true;
                } else {
                    i = j;
                }
            }
        } while (doSomething);

        return s;
    }
}