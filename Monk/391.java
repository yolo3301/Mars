public class Solution {
    public boolean isRectangleCover(int[][] rectangles) {
        if (rectangles.length == 0) return false;

        Set<String> set = new HashSet<>();
        int x1 = Integer.MAX_VALUE;
        int y1 = Integer.MAX_VALUE;
        int x2 = Integer.MIN_VALUE;
        int y2 = Integer.MIN_VALUE;
        int sumArea = 0;
        for (int[] rec : rectangles) {
            x1 = Math.min(x1, rec[0]);
            y1 = Math.min(y1, rec[1]);
            x2 = Math.max(x2, rec[2]);
            y2 = Math.max(y2, rec[3]);

            sumArea += (rec[2] - rec[0]) * (rec[3] - rec[1]);

            if (!set.add(rec[0] + " " + rec[1])) set.remove(rec[0] + " " + rec[1]);
            if (!set.add(rec[0] + " " + rec[3])) set.remove(rec[0] + " " + rec[3]);
            if (!set.add(rec[2] + " " + rec[3])) set.remove(rec[2] + " " + rec[3]);
            if (!set.add(rec[2] + " " + rec[1])) set.remove(rec[2] + " " + rec[1]);
        }

        if (!set.contains(x1 + " " + y1)
            || !set.contains(x1 + " " + y2)
            || !set.contains(x2 + " " + y1)
            || !set.contains(x2 + " " + y2)
            || set.size() != 4) return false;

        return sumArea == (x2-x1) * (y2-y1);
    }
}