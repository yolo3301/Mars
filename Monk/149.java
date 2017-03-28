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

        Map<Double, Integer> cnt1 = new HashMap<>();
        int res = 0;
        for (int i = 0; i < points.length; i++) {
            Point p1 = points[i];
            cnt1.clear();
            int cnt2 = 0, cnt3 = 0, cnt4 = 0, max = 0; // cnt2 vertical, cnt3 same point
            for (int j = i + 1; j < points.length; j++) {
                Point p2 = points[j];
                if (p1.x == p2.x && p1.y == p2.y) {
                    ++cnt3;
                } else if (p1.x == p2.x) {
                    max = Math.max(max, ++cnt4);
                } else if (p1.y == p2.y) {
                    max = Math.max(max, ++cnt2);
                } else {
                    double z = (double)(p2.x-p1.x) / (double)(p2.y-p1.y);
                    cnt1.put(z, cnt1.getOrDefault(z, 0)+1);
                    max = Math.max(max, cnt1.get(z));
                }
            }
            res = Math.max(res, 1 + max + cnt3);
        }

        return res;
    }
}