public class Solution {
    public boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {
        Map<Double, Integer> cnt = new HashMap<>();
        double d1 = dist(p1, p2);
        cnt.put(d1, cnt.getOrDefault(d1, 0)+1);
        double d2 = dist(p1, p3);
        cnt.put(d2, cnt.getOrDefault(d2, 0)+1);
        double d3 = dist(p1, p4);
        cnt.put(d3, cnt.getOrDefault(d3, 0)+1);
        double d4 = dist(p2, p3);
        cnt.put(d4, cnt.getOrDefault(d4, 0)+1);
        double d5 = dist(p2, p4);
        cnt.put(d5, cnt.getOrDefault(d5, 0)+1);
        double d6 = dist(p3, p4);
        cnt.put(d6, cnt.getOrDefault(d6, 0)+1);

        if (cnt.size() != 2) return false;

        boolean four = false, two = false;
        for (double key : cnt.keySet()) {
            if (cnt.get(key) == 4) four = true;
            if (cnt.get(key) == 2) two = true;
        }

        return four && two;
    }

    private double dist(int[] p1, int[] p2) {
        double x = Math.pow((p1[0]-p2[0]), 2.0);
        double y = Math.pow((p1[1]-p2[1]), 2.0);
        return Math.sqrt(x+y);
    }
}