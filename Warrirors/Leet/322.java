public class Solution {
    public int coinChange(int[] coins, int amount) {
        if (amount == 0) return 0;
        if (coins.length == 0) return -1;

        Arrays.sort(coins);
        int[] mem = new int[amount + 1];
        Arrays.fill(mem, -1);

        for (int i = 1; i <= amount; i++) {
            int curr = Integer.MAX_VALUE;
            for (int j = 0; j < coins.length && coins[j] <= i; j++) {
                if (i == coins[j]) {
                    curr = 1;
                    break;
                } else if (mem[i - coins[j]] > 0) {
                    curr = Math.min(curr, mem[i - coins[j]] + 1);
                }
            }
            if (curr < Integer.MAX_VALUE) mem[i] = curr;
        }

        return mem[amount];
    }
}
