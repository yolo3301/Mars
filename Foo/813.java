class Solution {
    public double largestSumOfAverages(int[] A, int K) {
        double[] sums = new double[A.length+1];

        for (int i = 1; i <= A.length; i++) {
            sums[i] = sums[i-1] + A[i-1];
        }

        double[] dp = new double[A.length];
        for (int i = 0; i < A.length; i++) {
            dp[i] = (sums[A.length] - sums[i]) / (A.length - i);
        }
        
        // System.out.println(Arrays.toString(dp));

        for (int k = 0; k < K-1; k++) {
            for (int i = 0; i < A.length; i++) {
                for (int j = i+1; j < A.length; j++) {
                    dp[i] = Math.max(dp[i], dp[j] + (sums[j] - sums[i]) / (j-i));
                }
            }
        }

        return dp[0];
    }
}