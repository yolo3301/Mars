public class Solution {
    public int minCost(int[][] costs) {
        if (costs.length == 0) return 0;
        int r = costs[0][0], g = costs[0][1], b = costs[0][2];
        for (int i = 1; i < costs.length; i++) {
            int tr = Math.min(g, b) + costs[i][0];
            int tg = Math.min(r, b) + costs[i][1];
            int tb = Math.min(r, g) + costs[i][2];
            r = tr;
            g = tg;
            b = tb;
        }

        return Math.min(r, Math.min(g, b));
    }
}