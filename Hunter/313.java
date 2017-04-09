public class Solution {
    public int nthSuperUglyNumber(int n, int[] primes) {
        if (n == 1) return 1;

        PriorityQueue<int[]> heap = new PriorityQueue<>((a, b) -> {
            return a[0] - b[0];
        });
        for (int j = 0; j < primes.length; j++) {
            heap.add(new int[]{primes[j], primes[j], 0}); // {actual ugly, prime, index}
        }
        int[] ugly = new int[n];
        ugly[0] = 1;

        for (int i = 1; i < n; i++) {
            ugly[i] = heap.peek()[0];
            while (heap.peek()[0] == ugly[i]) {
                int[] curr = heap.remove();
                heap.add(new int[]{curr[1]*ugly[curr[2]+1], curr[1], curr[2]+1});
            }
        }

        return ugly[n-1];
    }
}