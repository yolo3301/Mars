public class Solution {
    public int minTotalDistance(int[][] grid) {
        if (grid.length == 0) return 0;
        int m = grid.length;
        if (grid[0].length == 0) return 0;
        int n = grid[0].length;
        int[] row = new int[m];
        int[] col = new int[n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    row[i]++;
                    col[j]++;
                }
            }
        }

        return minDistance(row)+minDistance(col);
    }

    private int minDistance(int[] nums) {
        int i = 0, j = nums.length-1, sum = 0, left = nums[i], right = nums[j];
        while (i < j) {
            if (left < right) {
                sum += left;
                left += nums[++i];
            } else {
                sum += right;
                right += nums[--j];
            }
        }

        return sum;
    }
}