public class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int[] left = new int[gas.length];
        int sum = 0;
        for (int i = 0; i < gas.length; i++) {
            left[i] = gas[i] - cost[i];
            sum += left[i];
        }

        if (sum < 0) return -1;

        int max = left[0];
        int maxS = 0;
        int maxr = left[0];
        int maxrs = 0;
        for (int i = 1; i < left.length; i++) {
            int curr, currs;
            if (left[i] > left[i] + max) {
                max = left[i];
                maxS = i;
            } else {
                max = left[i] + max;
            }

            if (max > maxr) {
                maxr = max;
                maxrs = maxS;
            }
        }

        int min = left[0];
        int minr = left[0];
        int minrs = 0;
        for (int i = 1; i < left.length; i++) {
            if (left[i] < left[i] + min) {
                min = left[i];
            } else {
                min = left[i] + min;
            }

            if (min < minr) {
                minr = min;
                minrs = i;
            }
        }

        // critical
        if (maxr > sum - minr) {
            return maxrs;
        } else {
            return (minrs + 1) % left.length;
        }
    }
}
