public class Solution {
    public int compareVersion(String version1, String version2) {
        String[] p1 = version1.split("\\.");
        String[] p2 = version2.split("\\.");

        int i;
        for (i = 0; i < Math.min(p1.length, p2.length); i++) {
            long v1 = Long.parseLong(p1[i]);
            long v2 = Long.parseLong(p2[i]);
            if (v1 > v2) return 1;
            else if (v1 < v2) return -1;
        }

        while (i < p1.length) {
            if (Long.parseLong(p1[i++]) > 0)
                return 1;

        }
        while (i < p2.length) {
            if (Long.parseLong(p2[i++]) > 0)
                return -1;
        }

        return 0;
    }
}
