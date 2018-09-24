class Solution {
    public int numFactoredBinaryTrees(int[] A) {
        int mod = 1000000007;
        long ret = 0;
        Arrays.sort(A);
        Map<Integer, Long> map = new HashMap<>();
        for (int a : A) {
            map.put(a, 1l);
            ret++;
        }

        for (int i = 1; i < A.length; i++) {
            for (int j = i-1; j >= 0; j--) {
                if (A[i]%A[j] == 0 && map.containsKey(A[i]/A[j])) {
                    long v1 = map.get(A[j]);
                    long v2 = map.get(A[i]/A[j]);
                    long v = v1*v2;
                    map.put(A[i], (map.get(A[i]) + v) % mod);
                    ret = (ret+v) % mod;
                }
            }
        }

        return (int)ret;
    }
}