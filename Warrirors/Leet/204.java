public class Solution {
    public int countPrimes(int n) {
        if (n < 3) return 0;
        int res = 0;
        int[] prime = new int[n];
        for (int i = 2; i < n; i++) {
            if (prime[i] == 0) {
                res++;
                for (int j = 2 * i; j < n; j += i) {
                    prime[j] = 1;
                }
            }
        }

        return res;
    }
}
