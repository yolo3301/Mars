public class Solution {
    public int findPoisonedDuration(int[] timeSeries, int duration) {
        if (timeSeries.length == 0) return 0;
        int res = 0, boundry = timeSeries[0] + duration;
        for (int i = 1; i < timeSeries.length; i++) {
            if (timeSeries[i] <= boundry) {
                res += timeSeries[i] - timeSeries[i-1];
            } else {
                res += boundry - timeSeries[i-1];
            }
            boundry = timeSeries[i] + duration;
        }

        res += duration;

        return res;
    }
}