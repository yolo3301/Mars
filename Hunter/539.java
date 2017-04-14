public class Solution {
    public int findMinDifference(List<String> timePoints) {
        int[][] points = new int[timePoints.size()][2];
        for (int i = 0; i < timePoints.size(); i++) {
            String[] time = timePoints.get(i).split(":");
            points[i][0] = Integer.parseInt(time[0]);
            points[i][1] = Integer.parseInt(time[1]);
        }
        Arrays.sort(points, (a, b) -> {
            if (a[0] != b[0]) return a[0] - b[0];
            else return a[1] - b[1];
        });

        int res = Integer.MAX_VALUE;
        for (int i = 1; i < points.length; i++) {
            res = Math.min(res, diff(points[i-1], points[i]));
            if (res == 0) break;
        }

        res = Math.min(res, diff(points[points.length - 1], points[0]));

        return res;
    }

    private int diff(int[] t1, int[] t2) {
        if (t2[0] > t1[0] || (t2[0] == t1[0] && t2[1] >= t1[1]))
            return 60 * (t2[0] - t1[0]) + t2[1] - t1[1];

        return 60 * (t2[0] + 24 - t1[0]) + t2[1] - t1[1];
    }
}