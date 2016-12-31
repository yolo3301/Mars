// better solution here: https://discuss.leetcode.com/topic/59903/very-easy-to-understand-java-solution-with-explanations
public class Solution {
    public boolean canCross(int[] stones) {
        if (stones.length <= 1) return true;
        if (stones[0] != 0 || stones[1] != 1) return false;

        int len = stones.length;
        boolean[][] dp = new boolean[len][maxK(stones[stones.length - 1])+1];
        dp[0][1] = true;
        Map<Integer, Integer> index = new HashMap<>();
        for (int i = 0; i < len; i++)  {
            index.put(stones[i], i);
        }

        for (int i = 1; i < len; i++) {
            int mk = maxK(stones[i]);

            if (stones[i] - mk > stones[i-1])
                return false;

            for (int j = mk; j > 0; j--) {
                if (index.containsKey(stones[i] - j)) {
                    dp[i][j] |= dp[index.get(stones[i] - j)][j];
                }
                if (index.containsKey(stones[i] - j + 1)) {
                    dp[i][j] |= dp[index.get(stones[i] - j + 1)][j - 1];
                }
                if (index.containsKey(stones[i] - j - 1) && j + 1 <= mk) {
                    dp[i][j] |= dp[index.get(stones[i] - j - 1)][j + 1];
                }

                if (i == len - 1 && dp[i][j]) return true;
            }
        }

        return false;
    }

    private int maxK(int num) {
        if (num == 0) return 1;

        long sum = 0;
        int add = 1;
        while (num >= sum) {
            sum += add;
            add++;
        }

        return --add;
    }
}
