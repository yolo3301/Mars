public class Solution {
    public int findMinArrowShots(int[][] points) {
        if (points.length == 0) return 0;
        Arrays.sort(points, new Comparator<int[]>() {
            public int compare(int[] v1, int[] v2) {
                if (v1[0] != v2[0]) return v1[0] - v2[0];
                return v2[1] - v1[1];
            }
        });

        int res = 0, i = 0;
        while (i < points.length) {
            int j = i, board = points[i][1];
            while (j < points.length && board >= points[j][0]) {
                board = Math.min(board, points[j][1]);
                j++;
            }
            res++;
            i = j;
        }

        return res;
    }
}
