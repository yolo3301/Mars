class Solution {
    public boolean isBipartite(int[][] graph) {
        Set<Integer> visited = new HashSet<>();
        for (int i = 0; i < graph.length; i++) {
            if (graph[i].length > 0) {
                if (visited.contains(i)) continue;
                if (!sub(graph, i, visited))
                    return false;
            }
        }
        return true;
    }

    private boolean sub(int[][] graph, int start, Set<Integer> visited) {
        Set<Integer> group1 = new HashSet<>();
        Set<Integer> group2 = new HashSet<>();
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        group1.add(start);
        boolean in1 = true;

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int cur = queue.remove();
                visited.add(cur);
                for (int next : graph[cur]) {
                    if (in1 && group1.contains(next)) return false;
                    if (!in1 && group2.contains(next)) return false;
                    if (in1 && !group2.contains(next)) {
                        group2.add(next);
                        queue.add(next);
                    } else if (!in1 && !group1.contains(next)) {
                        group1.add(next);
                        queue.add(next);
                    }
                }
            }
            in1 = !in1;
        }

        return true;
    }
}