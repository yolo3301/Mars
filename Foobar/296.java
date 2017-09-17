class Solution {
    public int minTotalDistance(int[][] grid) {
        int m = grid.length;
        if (m == 0) return 0;
        int n = grid[0].length;
        if (n == 0) return 0;

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

        return minDist(row)+minDist(col);
    }

    private int minDist(int[] nums) {
        int sum = 0, i = 0, j = nums.length-1;
        int left = nums[i], right = nums[j];

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