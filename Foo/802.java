class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        Queue<Integer> q = new LinkedList<>();
        Map<Integer, Set<Integer>> out = new HashMap<>();
        Map<Integer, Set<Integer>> in = new HashMap<>();
        for (int i = 0; i < graph.length; i++) {
            if (graph[i].length == 0) {
                q.add(i);
            } else {
                if (!out.containsKey(i)) out.put(i, new HashSet<>());
                for (int j : graph[i]) {
                    out.get(i).add(j);
                    if (!in.containsKey(j)) in.put(j, new HashSet<>());
                    in.get(j).add(i);
                }
            }
        }

        List<Integer> ret = new ArrayList<>();
        while (!q.isEmpty()) {
            int cur = q.remove();
            ret.add(cur);
            if (in.containsKey(cur)) {
                for (int prev : in.get(cur)) {
                    out.get(prev).remove(cur);
                    if (out.get(prev).isEmpty()) {
                        q.add(prev);
                        out.remove(prev);
                    }
                }
            }
        }

        Collections.sort(ret);
        return ret;
    }
}