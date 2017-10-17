class Solution {

    Map<Integer, Integer> memo = new HashMap<>();

    public int numSquares(int n) {
        if (n == 1) return 1;
        if (memo.containsKey(n)) return memo.get(n);

        int limit = Math.sqrt(n);
        int ret = Integer.MAX_VALUE;
        for (int i = limit; i >= 1; i--) {
            ret = Math.min(ret, 1+numSquares(n-i*i));
        }

        memo.put(n, ret);
        return ret;
    }
}
