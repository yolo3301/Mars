public class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if (numCourses == 0) return true;
        List<Integer>[] neighbors = new ArrayList[numCourses];
        for (int i = 0; i < numCourses; i++) {
            neighbors[i] = new ArrayList<>();
        }
        for (int[] edge : prerequisites) {
            neighbors[edge[0]].add(edge[1]);
        }

        int[] status = new int[numCourses];
        boolean res = true;
        for (int[] edge : prerequisites) {
            if (status[edge[0]] == 0)
                res &= dfs(edge[0], neighbors, status);
            if (!res) break;
        }

        return res;
    }

    private boolean dfs(int curr, List<Integer>[] neighbors, int[] status) {
        if (status[curr] == 1) return false;
        if (status[curr] == 2) return true;

        status[curr] = 1;
        boolean res = true;
        for (int next : neighbors[curr]) {
            res &= dfs(next, neighbors, status);
            if (!res) break;
        }
        status[curr] = 2;

        return res;
    }
}