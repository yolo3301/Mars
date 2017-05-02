public class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if (numCourses <= 1) return true;
        Map<Integer, Set<Integer>> deps = new HashMap<>();
        for (int[] pre : prerequisites) {
            if (!deps.containsKey(pre[0])) deps.put(pre[0], new HashSet<>());
            deps.get(pre[0]).add(pre[1]);
        }

        int[] status = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            if (!dfs(i, deps, status)) return false;
        }

        return true;
    }

    private boolean dfs(int curr, Map<Integer, Set<Integer>> deps, int[] status) {
        if (status[curr] == 2) return true;
        if (status[curr] == 1) return false;

        status[curr] = 1;
        boolean res = true;
        if (deps.containsKey(curr)) {
            for (int next : deps.get(curr)) {
                res &= dfs(next, deps, status);
                if (!res) break;
            }
        }
        status[curr] = 2;

        return res;
    }
}