public class Solution {
    public int findKthNumber(int n, int k) {
        if (k == 1) return 1;
        k--;
        int curr = 1;
        while (k > 0) {
            int steps = steps(curr, curr+1, n);
            if (steps <= k) {
                k -= steps;
                curr++;
            } else {
                k--;
                curr *= 10;
            }
        }

        return curr;
    }

    private int steps(long n1, long n2, int n) {
        int steps = 0;
        while (n1 <= n) {
            steps += Math.min(n+1, n2) - n1;
            n1 *= 10;
            n2 *= 10;
        }

        return steps;
    }
}