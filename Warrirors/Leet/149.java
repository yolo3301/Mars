/**
 * Definition for a point.
 * class Point {
 *     int x;
 *     int y;
 *     Point() { x = 0; y = 0; }
 *     Point(int a, int b) { x = a; y = b; }
 * }
 */
public class Solution {
    public int maxPoints(Point[] points) {
        if (points.length <= 2) return points.length;
        int res = 0;

        Map<Double, Integer> count = new HashMap<>();
        for (int i = 0; i < points.length - 1; i++) {
            count.clear();
            int overlap = 0, max = 0, yz = 0;
            for (int j = i + 1; j < points.length; j++) {
                int x = points[j].x-points[i].x;
                int y = points[j].y-points[i].y;
                if (x == 0 && y == 0) {
                    overlap++;
                } else if (y == 0) {
                    yz++;
                    max = Math.max(max, yz);
                } else {
                    double z = (double)x / (double)y;
                    if (count.containsKey(z)) {
                        count.put(z, count.get(z) + 1);
                    } else {
                        count.put(z, 1);
                    }
                    max = Math.max(max, count.get(z));
                }
            }
            res = Math.max(res, max + overlap + 1);
        }

        return res;
    }
}
