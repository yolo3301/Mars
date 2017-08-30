class Solution {
    public List<Integer> cheapestJump(int[] A, int B) {
        int[] dp = new int[A.length];
        List<Integer>[] paths = new ArrayList[A.length];
        dp[0] = A[0];
        paths[0] = new ArrayList<>();
        paths[0].add(1);

        for (int i = 1; i < A.length; i++) {
            dp[i] = Integer.MAX_VALUE;
            paths[i] = new ArrayList<>();
            if (A[i] == -1) continue;
            for (int j = 1; j <= B && i-j >= 0; j++) {
                if (A[i-j] == -1) continue;
                if (A[i] + dp[i-j] < dp[i]) {
                    dp[i] = A[i] + dp[i-j];
                    paths[i] = new ArrayList<>();
                    paths[i].addAll(paths[i-j]);
                    paths[i].add(i+1);
                } else if (A[i] + dp[i-j] == dp[i]) {
                    if (paths[i].size() == paths[i-j].size() + 1) {
                        paths[i] = new ArrayList<>();
                        paths[i].addAll(paths[i-j]);
                        paths[i].add(i+1);
                    }
                }
            }
        }

        return (!paths[A.length-1].isEmpty() && paths[A.length-1].get(0) == 1) ? paths[A.length-1] : new ArrayList<>();
    }
}