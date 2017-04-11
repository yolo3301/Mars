public class Solution {
    public int countArrangement(int N) {
        memo = new HashMap<>();
        Set<Integer> pool = new HashSet<>();
        for (int i = 1; i <= N; i++) pool.add(i);
        return bt(1, N, pool);
    }

    Map<String, Integer> memo;

    private int bt(int index, int N, Set<Integer> pool) {
        if (index == N+1) return 1;

        String key = generateKey(index, N, pool);
        if (memo.containsKey(key)) return memo.get(key);

        int res = 0;
        for (int i = 1; i <= N; i++) {
            if (pool.contains(i) && (index % i == 0 || i % index == 0)) {
                pool.remove(i);
                res += bt(index+1, N, pool);
                pool.add(i);
            }
        }

        memo.put(key, res);

        return res;
    }

    private String generateKey(int index, int N, Set<Integer> pool) {
        int k = 0;
        for (int i = 1; i <= N; i++) {
            k <<= 1;
            if (pool.contains(i)) k |= 1;
        }

        return new StringBuilder(index).append(';').append(k).toString();
    }
}