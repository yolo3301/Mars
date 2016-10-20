public class Solution {
    public int numTrees(int n) {
        if (n == 0 || n == 1) return n;
        int[] mem = new int[n + 1];
        mem[0] = 1;
        mem[1] = 1;
        mem[2] = 2;

        for (int i = 3; i <= n; i++) {
            int curr = 0;
            for (int j = 1; j <= i; j++) {
                curr += mem[j - 1] * mem[i - j];
            }
            mem[i] = curr;
        }

        return mem[n];
    }
}
