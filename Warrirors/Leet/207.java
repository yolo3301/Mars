// topology sort
public class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if (prerequisites.length == 0) return true;

        Queue<Integer> next = new LinkedList<>();
        Map<Integer, Set<Integer>> income = new HashMap<>();
        Map<Integer, Set<Integer>> outcome = new HashMap<>();

        for (int i = 0; i < prerequisites.length; i++) {
            if (prerequisites[i][0] == prerequisites[i][1])
                return false;

            if (!income.containsKey(prerequisites[i][1])) {
                income.put(prerequisites[i][1], new HashSet<Integer>());
            }
            income.get(prerequisites[i][1]).add(prerequisites[i][0]);

            if (!income.containsKey(prerequisites[i][0])) {
                income.put(prerequisites[i][0], new HashSet<Integer>());
            }

            if (!outcome.containsKey(prerequisites[i][0])) {
                outcome.put(prerequisites[i][0], new HashSet<Integer>());
            }
            outcome.get(prerequisites[i][0]).add(prerequisites[i][1]);

            if (!outcome.containsKey(prerequisites[i][1])) {
                outcome.put(prerequisites[i][1], new HashSet<Integer>());
            }
        }

        for (Map.Entry<Integer, Set<Integer>> entry : income.entrySet()) {
            if (entry.getValue().isEmpty()) {
                next.add(entry.getKey());
            }
        }

        while (!next.isEmpty()) {
            int curr = next.remove();
            for (Integer j : outcome.get(curr)) {
                income.get(j).remove(curr);
                if (income.get(j).isEmpty()) {
                    next.add(j);
                }
            }
        }

        for (Map.Entry<Integer, Set<Integer>> entry : income.entrySet()) {
            if (!entry.getValue().isEmpty()) return false;
        }

        return true;
    }
}


// dfs
public class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if (numCourses == 0 || prerequisites.length == 0) return true;
        List<Integer>[] adj = new ArrayList[numCourses];
        int[] status = new int[numCourses];

        for (int i = 0; i < numCourses; i++) {
            adj[i] = new ArrayList<Integer>();
        }

        for (int[] pre : prerequisites) {
            adj[pre[0]].add(pre[1]);
        }

        boolean res = true;
        for (int i = 0; i < numCourses; i++) {
            if (status[i] == 0) {
                res &= dfs(i, adj, status);
            }
        }

        return res;
    }

    private boolean dfs(int curr, List<Integer>[] adj, int[] status) {
        if (status[curr] == 1) return false;
        if (status[curr] == 2) return true;

        status[curr] = 1;
        boolean res = true;
        for (Integer next : adj[curr]) {
            res &= dfs(next, adj, status);
            if (!res) break;
        }

        status[curr] = 2;
        return res;
    }
}
