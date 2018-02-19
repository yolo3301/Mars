class Solution {
    public double minmaxGasDist(int[] stations, int K) {
        if (stations.length <= 1) return 0;
        PriorityQueue<double[]> q = new PriorityQueue<>((a, b) -> {
            return b[0] - a[0];
        });

        for (int i = 1; i < stations.length; i++) {
            double diff = (double)(stations[i] - stations[i-1]);
            q.add(new double[]{diff, 0.0});
        }

        while (K-- > 0) {
            double[] cur = q.remove();
            double total = cur[0] * (cur[1] + 1);
            double[] next = new double[]{total / (cur[1] + 2), cur[1] + 1};
            q.add(next);
        }

        return q.peek()[0];
    }
}

class Solution {
    public double minmaxGasDist(int[] stations, int K) {
        double left = 0, right = stations[stations.length-1] - stations[0];
        while (left + 0.000006 < right) {
            double mid = left + (right - left) / 2;
            if (possible(stations, K, mid)) {
                right = mid;
            } else {
                left = mid;
            }
        }
        return left;
    }

    private boolean possible(int[] stations, int K, double m) {
        int cnt = 0;
        for (int i = 0; i < stations.length - 1; i++) {
            cnt += Math.ceil((stations[i+1] - stations[i]) / m) - 1;
        }

        return cnt <= K;
    }
}