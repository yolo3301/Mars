public class Solution {
    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        int common;
        if (A >= G || B >= H || C <= E || D <= F) common = 0;
        else {
            int a = Math.max(A, E);
            int b = Math.max(B, F);
            int c = Math.min(C, G);
            int d = Math.min(D, H);
            common = (c - a) * (d - b);
        }

        return (C - A) * (D - B) + (G - E) * (H - F) - common;
    }
}
