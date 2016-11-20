// reference: https://discuss.leetcode.com/topic/30956/two-o-n-solutions
public class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        if (n <= 0) return new ArrayList<>();
        if (n == 1) return Arrays.asList(0);
        List<Integer>[] e = new ArrayList[n];
        for (int i = 0; i < n; i++)
            e[i] = new ArrayList<>();
        for (int i = 0; i < edges.length; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            e[u].add(v);
            e[v].add(u);
        }

        int[] dist1 = new int[n];
        int[] pre = new int[n];
        bfs(0, e, dist1, pre);
        int l1 = 0;
        for (int i = 1; i < n; i++) {
            if (dist1[i] > dist1[l1])
                l1 = i;
        }

        int[] dist2 = new int[n];
        bfs(l1, e, dist2, pre);
        int l2 = 0;
        for (int i = 1; i < n; i++) {
            if (dist2[i] > dist2[l2])
                l2 = i;
        }

        List<Integer> res = new ArrayList<>();
        int j = l2;
        while (j != -1) {
            res.add(j);
            j = pre[j];
        }

        if (res.size() % 2 == 1) return Arrays.asList(res.get(res.size() / 2));
        else return Arrays.asList(res.get(res.size() / 2), res.get(res.size() / 2 - 1));
    }

    private void bfs(int start, List<Integer>[] e, int[] dist, int[] pre) {
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        int step = 0;
        pre[start] = -1;
        boolean[] visited = new boolean[e.length];

        while (!q.isEmpty()) {
            int currSize = q.size();
            for (int j = 0; j < currSize; j++) {
                int curr = q.remove();
                visited[curr] = true;
                dist[curr] = step;
                for (int next : e[curr]) {
                    if (!visited[next]) {
                        pre[next] = curr;
                        q.add(next);
                    }
                }
            }
            step++;
        }
    }
}
