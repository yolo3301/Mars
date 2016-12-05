// reference: https://discuss.leetcode.com/topic/68896/java-solution-using-hashmap-with-detailed-explanation/2
public class Solution {
    boolean[] used;
    Map<Integer, Boolean> memo;

    public boolean canIWin(int maxChoosableInteger, int desiredTotal) {
        if ((1 + maxChoosableInteger) * maxChoosableInteger / 2 < desiredTotal) return false;
        if (desiredTotal <= 0) return true;

        used = new boolean[maxChoosableInteger + 1];
        memo = new HashMap<>();

        return canWin(desiredTotal);
    }

    private boolean canWin(int total) {
        // if total is already less than 0, then it measn the other guy won
        if (total <= 0) return false;
        int k = getKey();
        if (memo.containsKey(k)) return memo.get(k);

        for (int i = 1; i < used.length; i++) {
            if (!used[i]) {
                used[i] = true;
                // if the other guy cannot win, then I win
                if (!canWin(total - i)) {
                    memo.put(k, true);
                    used[i] = false;
                    break;
                }
                used[i] = false;
            }
        }

        // If nothing put, then it means I have no way to win -- aka lose
        if (!memo.containsKey(k)) memo.put(k, false);

        return memo.get(k);
    }

    private int getKey() {
        int k = 0;
        for (int i = 1; i < used.length; i++) {
            k <<= 1;
            if (used[i]) k |= 1;
        }
        return k;
    }
}
