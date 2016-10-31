public class Solution {
    public int numSquares(int n) {
        int max = (int) Math.sqrt(n);
        int[] square = new int[max];
        for (int i = 0; i < max; i++) {
            square[i] = (i+1) * (i+1);
        }

        int[] mem = new int[n+1];
        mem[1] = 1;
        for (int i = 2; i <= n; i++) {
            mem[i] = Integer.MAX_VALUE;
            for (int j = 0; j < max; j++) {
                if (square[j] <= i) {
                    mem[i] = Math.min(mem[i], mem[i - square[j]] + 1);
                } else {
                    break;
                }
            }
        }

        return mem[n];
    }
}
