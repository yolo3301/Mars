class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
        int[] lowest = new int[n];
        Arrays.fill(lowest, Integer.MAX_VALUE);
        lowest[src] = 0;

        Map<Integer, List<int[]>> map = new HashMap<>();
        for (int[] f : flights) {
            if (!map.containsKey(f[0])) map.put(f[0], new ArrayList<>());
            map.get(f[0]).add(new int[]{f[1], f[2]});
        }

        Queue<Integer> q = new LinkedList<>();
        q.add(src);

        int step = 0;
        while (!q.isEmpty() && step <= K) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int cur = q.remove();
                if (map.containsKey(cur)) {
                    for (int[] next : map.get(cur)) {
                        if (lowest[cur] + next[1] < lowest[next[0]]) {
                            q.add(next[0]);
                            lowest[next[0]] = lowest[cur] + next[1];
                        }
                    }
                }
            }
            step++;
        }

        if (lowest[dst] == Integer.MAX_VALUE) return -1;
        return lowest[dst];
    }
}