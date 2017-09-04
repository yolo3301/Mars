class Solution {
    public boolean isConvex(List<List<Integer>> points) {
        int size = points.size();
        boolean pos = false, neg = false;
        for (int a = 0; a < size; a++) {
            int b = (a+1) % size;
            int c = (b+1) % size;

            int product = crossProduct(
                points.get(a).get(0),
                points.get(a).get(1),
                points.get(b).get(0),
                points.get(b).get(1),
                points.get(c).get(0),
                points.get(c).get(1)
            );

            if (product < 0) neg = true;
            else if (product > 0) pos = true;

            if (pos && neg) return false;
        }

        return true;
    }

    private int crossProduct(int ax, int ay, int bx, int by, int cx, int cy) {
        int bax = ax - bx;
        int bay = ay - by;
        int bcx = cx - bx;
        int bcy = cy - by;
        return (bax * bcy - bay * bcx);
    }
}