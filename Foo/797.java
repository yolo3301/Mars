class Solution {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> ret = new ArrayList<>();
        dfs(0, graph, new ArrayList<>(), ret);
        return ret;
    }

    private void dfs(int cur, int[][] graph, List<Integer> buf, List<List<Integer>> ret) {
        buf.add(cur);
        if (cur == graph.length-1) {
            ret.add(new ArrayList<>(buf));
            buf.remove(buf.size()-1);
            return;
        }

        for (int next : graph[cur]) {
            if (next > cur) {
                dfs(next, graph, buf, ret);
            }
        }

        buf.remove(buf.size()-1);
    }
}