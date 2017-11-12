class Solution {
    public boolean isRectangleCover(int[][] rectangles) {
        Set<String> set = new HashSet<>();
        int u = Integer.MIN_VALUE, r = Integer.MIN_VALUE;
        int l = Integer.MAX_VALUE, d = Integer.MAX_VALUE;
        int area = 0;

        for (int[] rec : rectangles) {
            u = Math.max(u, rec[2]);
            r = Math.max(r, rec[3]);
            l = Math.min(l, rec[1]);
            d = Math.min(d, rec[0]);

            area += (rec[3]-rec[1]) * (rec[2]-rec[0]);

            String p1 = rec[0] + " " + rec[1];
            String p2 = rec[2] + " " + rec[3];
            String p3 = rec[0] + " " + rec[3];
            String p4 = rec[2] + " " + rec[1];

            update(set, p1);
            update(set, p2);
            update(set, p3);
            update(set, p4);
        }

        if (set.size() != 4) return false;

        return set.contains(d + " " + l)
            && set.contains(d + " " + r)
            && set.contains(u + " " + l)
            && set.contains(u + " " + r)
            && (area == (r-l)*(u-d));
    }

    private void update(Set<String> set, String val) {
        if (set.contains(val)) set.remove(val);
        else set.add(val);
    }
}