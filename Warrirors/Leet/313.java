// reference: https://discuss.leetcode.com/topic/34841/java-three-methods-23ms-36-ms-58ms-with-heap-performance-explained

public class Solution {
    public int nthSuperUglyNumber(int n, int[] primes) {
        if (n == 1) return 1;
        // pointers for each prime number
        int[] ps = new int[primes.length];
        int[] ugly = new int[n];
        ugly[0] = 1;
        for (int i = 1; i < n; i++) {
            ugly[i] = Integer.MAX_VALUE;
            for (int j = 0; j < primes.length; j++) {
                ugly[i] = Math.min(ugly[i], ugly[ps[j]] * primes[j]);
            }

            // move forward the pointer if there is duplicates
            for (int j = 0; j < primes.length; j++) {
                if (ugly[ps[j]] * primes[j] == ugly[i]) ps[j]++;
            }
        }

        return ugly[n - 1];
    }
}

// improve time complexity
public class Solution {
    public int nthSuperUglyNumber(int n, int[] primes) {
        if (n == 1) return 1;
        int[] ps = new int[primes.length];
        int[] ugly = new int[n];
        // the value of current round
        int[] val = new int[primes.length];
        Arrays.fill(val, 1);
        // the next ugly number
        int next = 1;
        for (int i = 0; i < n; i++) {
            // save next ugly number
            ugly[i] = next;
            next = Integer.MAX_VALUE;
            // calculate next round
            for (int j = 0; j < primes.length; j++) {
                // for those didn't get picked in the last round, stay the same
                // here only calculate the ones = the current ugly number, and move forward pointers
                if (val[j] == ugly[i]) val[j] = primes[j] * ugly[ps[j]++];
                // the smallest one is the next ugly number
                next = Math.min(next, val[j]);
            }
        }
        return ugly[n - 1];
    }
}
