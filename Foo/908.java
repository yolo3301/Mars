class Solution {
    public int smallestRangeI(int[] A, int K) {
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        for (int a : A) {
            min = Math.min(a, min);
            max = Math.max(a, max);
        }
        return Math.max(0, max-K-min-K);
    }
}