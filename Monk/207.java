public class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if (numCourses <= 1) return true;
        List<Integer>[] edges = new ArrayList[numCourses];
        for (int i = 0; i < numCourses; i++) {
            edges[i] = new ArrayList<>();
        }
        for (int[] p : prerequisites) {
            edges[p[0]].add(p[1]);
        }

        boolean res = true;
        int[] status = new int[numCourses];

        // Need to go through each because the graph can be segmented
        for (int[] p : prerequisites) {
            if (status[p[0]] == 0) {
                res &= dfs(p[0], edges, status);
            }
        }

        return res;
    }

    // status = 1 means the node is visited but not explored
    // status = 2 means the node is explored
    // running into an explored node is ok, but running into a visited one is not
    private boolean dfs(int curr, List<Integer>[] edges, int[] status) {
        if (status[curr] == 1) return false;
        if (status[curr] == 2) return true;

        boolean res = true;
        status[curr] = 1;
        for (int n : edges[curr]) {
            res &= dfs(n, edges, status);
            if (!res) break;
        }
        status[curr] = 2;

        return res;
    }
}