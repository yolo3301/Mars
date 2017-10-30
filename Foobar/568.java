class Solution {
    public int maxVacationDays(int[][] flights, int[][] days) {
        int n = flights.length;
        int k = days[0].length;
        if (k == 0) return 0;
        int[][] dp = new int[k+1][n];
        int ret = 0;

        Arrays.fill(dp[0], Integer.MIN_VALUE);
        dp[0][0] = 0;

        Map<Integer, Set<Integer>> last = new HashMap<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (flights[i][j] != 0) {
                    if (!last.containsKey(j))
                        last.put(j, new HashSet<>());
                    last.get(j).add(i);
                }
            }
        }

        for (int w = 1; w <= k; w++) {
            Arrays.fill(dp[w], Integer.MIN_VALUE);
            for (int c = 0; c < n; c++) {
                if (last.containsKey(c)) {
                    for (int prev : last.get(c)) {
                        dp[w][c] = Math.max(dp[w][c], dp[w-1][prev]+days[c][w-1]);
                    }
                }
                dp[w][c] = Math.max(dp[w][c], dp[w-1][c]+days[c][w-1]);
                if (w == k) ret = Math.max(ret, dp[w][c]);
            }
        }

        return ret;
    }
}

