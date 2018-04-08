class Solution {
    public int minSwap(int[] A, int[] B) {
        // natual vs. swapped
        int n1 = 0, s1 = 1;
        for (int i = 1; i < A.length; i++) {
            int n2 = Integer.MAX_VALUE, s2 = Integer.MAX_VALUE;
            if (A[i-1] < A[i] && B[i-1] < B[i]) {
                n2 = Math.min(n2, n1); // no need to swap
                s2 = Math.min(s2, s1 + 1); // because last one swapped, also need to swap the current
            }

            if (A[i-1] < B[i] && B[i-1] < A[i]) {
                n2 = Math.min(n2, s1); // because last one swapped, this one doesn't need to swap
                s2 = Math.min(s2, n1 + 1); // because last doesn't swap, this one needs to swap
            }

            n1 = n2;
            s1 = s2;
        }

        return Math.min(n1, s1);
    }
}