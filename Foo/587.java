/**
 * Definition for a point.
 * class Point {
 *     int x;
 *     int y;
 *     Point() { x = 0; y = 0; }
 *     Point(int a, int b) { x = a; y = b; }
 * }
 */
class Solution {
    public List<Point> outerTrees(Point[] points) {
        Set<Point> res = new HashSet<>();

        Point first = points[0];
        int firstIndex = 0;
        for (int i = 1; i < points.length; i++) {
            if (points[i].x < first.x) {
                first = points[i];
                firstIndex = i;
            }
        }
        res.add(first);

        int curr = first;
        int currIndex = firstIndex;

        do {
            Point next = points[0];
            int nextIndex = 0;

            for (int i = 1; i < points.length; i++) {
                if (i == currIndex) continue;
                int cross = crossProduct(curr.x, curr.y, points[i].x, points[i].y, next.x, next.y);
                if (nextIndex == currIndex || cross > 0
                    // cross == 0 means collinear, Handle collinear points
                    || (cross == 0 && dist(curr.x, curr.y, points[i].x, points[i].y) > dist(curr.x, curr.y, next.x, next.y))) {
                    next = points[i];
                    nextIndex = i;
                }
            }

            // Handle collinear points
            for (int i = 0; i < points.length; i++) {
                if (i == currIndex) continue;
                int cross = crossProduct(curr.x, curr.y, points[i].x, points[i].y, next.x, next.y);
                if (cross == 0) {
                    res.add(points[i]);
                }                
            }

            curr = next;
            currIndex = nextIndex;

        } while (currIndex != firstIndex);

        return new ArrayList<>(res);
    }

    private int crossProduct(int ax, int ay, int bx, int by, int cx, int cy) {
        int bax = ax - bx;
        int bay = ay - by;
        int bcx = cx - bx;
        int bcy = cy - by;
        return (bax * bcy - bay * bcx);
    }

    private int dist(int ax, int ay, int bx, int by) {
        return (ax-bx)*(ax-bx) + (ay-by)*(ay-by);
    }
}