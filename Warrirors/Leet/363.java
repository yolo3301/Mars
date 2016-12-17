// https://discuss.leetcode.com/topic/48854/java-binary-search-solution-time-complexity-min-m-n-2-max-m-n-log-max-m-n
public class Solution {
    public int maxSumSubmatrix(int[][] matrix, int k) {
        int row = matrix.length;
        if (row == 0) return 0;
        int col = matrix[0].length;
        if (col == 0) return 0;
        int m = Math.min(row, col);
        int n = Math.max(row, col);

        boolean bigCol = col > row;

        int res = Integer.MIN_VALUE;
        for (int i = 0; i < m; i++) {
            int[] sums = new int[n];
            for (int j = i; j < m; j++) {
                int sum = 0;
                // The set saves all previous pre-sums
                // Sum is the pre-sum so far
                // If we can find a previous sum meets the requirement
                // then it means the subarray meets the requirement
                TreeSet<Integer> set = new TreeSet<>();
                set.add(0);
                for (int p = 0; p < n; p++) {
                    sums[p] += bigCol ? matrix[j][p] : matrix[p][j];
                    sum += sums[p];
                    Integer curr = set.ceiling(sum - k);
                    if (curr != null) {
                        res = Math.max(res, sum - curr);
                    }
                    set.add(sum);
                }
            }
        }

        return res;
    }
}
