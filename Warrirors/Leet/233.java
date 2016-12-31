// Don't want to use the right solution because too math.
// https://discuss.leetcode.com/topic/18972/ac-short-java-solution
public class Solution {
    public int countDigitOne(int n) {
        if (n <= 0) return 0;
        int[] cache = new int[n+1];
        long res = 0;
        for (int i = 1; i <= n; i++) {
            int j = i;
            cache[i] = cache[i / 10];
            if (i % 10 == 1) cache[i]++;
            // System.out.println("i:" + i + "   " + cache[i] + "  prev:" + cache[i / 10]);
            res += cache[i];
        }

        return (int)res;
    }
}
