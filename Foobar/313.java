class Solution {
    public int nthSuperUglyNumber(int n, int[] primes) {
        PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> {
            return a[0] - b[0];
        });

        for (int i = 0; i < primes.length; i++) {
            queue.add(new int[]{ 1, i, 0 });
        }

        int[] ret = new int[n];
        for (int i = 0; i < n; i++) {
            int x = queue.peek()[0];
            ret[i] = x;

            if (i == n-1) break;

            while (queue.peek()[0] == x) {
                int[] cur = queue.remove();
                queue.add(new int[]{ ret[cur[2]]*primes[cur[1]], cur[1], cur[2]+1 });
            }
        }

        return ret[n-1];
    }
}
