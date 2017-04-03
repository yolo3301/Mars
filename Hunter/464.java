public class Solution {
    boolean[] used;
    Map<Integer, Boolean> memo;

    public boolean canIWin(int maxChoosableInteger, int desiredTotal) {
        if (maxChoosableInteger*(1+maxChoosableInteger) / 2 < desiredTotal) return false;
        if (desiredTotal <= 0) return true;
        used = new boolean[maxChoosableInteger+1];
        memo = new HashMap<>();

        return win(desiredTotal);
    }

    private boolean win(int total) {
        if (total <= 0) return false;
        int k = key();
        if (memo.containsKey(k)) return memo.get(k);

        for (int i = 1; i < used.length; i++) {
            if (!used[i]) {
                used[i] = true;
                if (!win(total - i)) {
                    memo.put(k, true);
                    used[i] = false;
                    break;
                }
                used[i] = false;
            }
        }

        if (!memo.containsKey(k)) memo.put(k, false);

        return memo.get(k);
    }

    private int key() {
        int k = 0;
        for (int i = 1; i < used.length; i++) {
            k <<= 1;
            if (used[i]) {
                k |= 1;
            }
        }

        return k;
    }
}