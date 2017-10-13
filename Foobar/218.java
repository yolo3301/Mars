class Solution {
    public List<int[]> getSkyline(int[][] buildings) {
        PriorityQueue<int[]> edges = new PriorityQueue<>((a, b) -> {
            if (a[0] != b[0]) return a[0] - b[0];
            return b[1] - a[1];
        });
        TreeMap<Integer, Integer> high = new TreeMap<>();

        high.put(0, 1);
        for (int[] b : buildings) {
            edges.add(new int[]{b[0], b[2]});
            edges.add(new int[]{b[1], -b[2]});
        }

        List<int[]> ret = new ArrayList<>();

        while (!edges.isEmpty()) {
            int[] cur = edges.remove();
            if (cur[1] >= 0) {
                high.put(cur[1], high.getOrDefault(cur[1], 0) + 1);
            } else {
                high.put(-cur[1], high.get(-cur[1])-1);
                if (high.get(-cur[1]) == 0) high.remove(-cur[1]);
            }

            int curHigh = high.lastKey();
            if (ret.isEmpty() || curHigh != ret.get(ret.size()-1)[1]) {
                ret.add(new int[]{cur[0], curHigh});
            }
        }

        return ret;
    }
}
