public class Solution {
    public int countComponents(int n, int[][] edges) {
        Map<Integer, Set<Integer>> neighbor = new HashMap<>();
        for (int i = 0; i < n; i++) neighbor.put(i, new HashSet<>());
        for (int[] e : edges) {
            neighbor.get(e[0]).add(e[1]);
            neighbor.get(e[1]).add(e[0]);
        }

        boolean[] visited = new boolean[n];
        int res = 0;
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                res++;
                bfs(i, neighbor, visited);
            }
        }

        return res;
    }

    private void bfs(int s, Map<Integer, Set<Integer>> neighbor, boolean[] visited) {
        Queue<Integer> q = new LinkedList<>();
        q.add(s);

        while (!q.isEmpty()) {
            int curr = q.remove();
            visited[curr] = true;
            for (int next : neighbor.get(curr)) {
                if (!visited[next]) q.add(next);
            }
        }
    }
}