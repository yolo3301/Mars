public class Solution {
    public int findMinDifference(List<String> timePoints) {
        List<int[]> times = new ArrayList<>();
        for (String t : timePoints) {
            String[] p = t.split(":");
            times.add(new int[]{Integer.valueOf(p[0]), Integer.valueOf(p[1])});
        }
        Collections.sort(times, (a, b) -> {
            if (a[0] != b[0]) return a[0] - b[0];
            return a[1] - b[1];
        });
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < times.size(); i++) {
            if (i == 0) {
                int m1 = toMinutes(times.get(i));
                int m2 = toMinutes(times.get(times.size()-1));
                res = Math.min(res, min)
            } else {
                int m1 = toMinutes(times.get(i));
                int m2 = toMinutes(times.get(i-1));
                res = Math.min(res, minDiff(m1, m2));
            }
        }

        return res;
    }

    private int toMinutes(int[] time) {
        return time[0] * 60 + time[1];
    }

    private int minDiff(int min1, int min2) {
        if (min1 < min2) return minDiff(min2, min1);

        return Math.min(min1-min2, min2+1440-min1);
    }
}