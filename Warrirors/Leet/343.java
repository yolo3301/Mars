// Not the best solution

public class Solution {
    public int integerBreak(int n) {
        if (n == 1 || n == 2) return 1;

        int[] mem = new int[n + 1];
        mem[1] = 1;
        mem[2] = 1;

        for (int i = 3; i <= n; i++) {
            for (int j = 1; j <= i / 2; j++) {
                mem[i] = Math.max(mem[i], mem[j] * mem[i - j]);
                mem[i] = Math.max(mem[i], mem[j] * (i - j));
                mem[i] = Math.max(mem[i], j * mem[i - j]);
                mem[i] = Math.max(mem[i], j * (i - j));
            }
        }

        return mem[n];
    }
}
