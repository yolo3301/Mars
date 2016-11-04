public class Solution {
    private int[][] mem;
    public int getMoneyAmount(int n) {
        mem = new int[n+1][n+1];
        return find(1, n);
    }

    private int find(int s, int e) {
        if (s == e) return 0;
        if (s + 1 == e) return s;
        if (mem[s][e] != 0) return mem[s][e];

        int min = Integer.MAX_VALUE;
        for (int i = s + 1; i < e; i++) {
            min = Math.min(min, Math.max(find(s, i - 1), find(i + 1, e)) + i);
        }

        mem[s][e] = min;
        return min;
    }
}
