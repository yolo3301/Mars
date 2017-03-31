public class Solution {
    public int findMaximizedCapital(int k, int W, int[] Profits, int[] Capital) {
        if (k == 0) return W;
        PriorityQueue<int[]> minCap = new PriorityQueue<>((a, b) -> (a[0] - b[0]));
        PriorityQueue<int[]> maxPro = new PriorityQueue<>((a, b) -> (b[1] - a[1]));

        for (int i = 0; i < Profits.length; i++) {
            minCap.add(new int[]{Capital[i], Profits[i]});
        }

        for (int i = 0; i < k; i++) {
            while (!minCap.isEmpty() && minCap.peek()[0] <= W) {
                maxPro.add(minCap.remove());
            }

            if (maxPro.isEmpty()) break;
            W += maxPro.remove()[1];
        }

        return W;
    }
}