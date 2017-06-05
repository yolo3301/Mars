public class Solution {
    public boolean isReflected(int[][] points) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        Set<String> set = new HashSet<>();

        for (int[] p : points) {
            min = Math.min(min, p[0]);
            max = Math.max(max, p[0]);
            set.add(p[0] + ";" + p[1]);
        }

        double mid = (double)(min + max) / 2;
        for (int[] p : points) {
            if (p[0] != mid) {
                int other = (int)(mid + mid - p[0]);
                if (!set.contains(other + ";" + p[1]))
                    return false;
            }
        }

        return true;
    }
}