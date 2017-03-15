public class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        if (numCourses == 0) return new int[0];

        Map<Integer, Set<Integer>> inedge = new HashMap<>();

        // to boost performance, only need to record number here
        Map<Integer, Set<Integer>> outedge = new HashMap<>();
        for (int i = 0; i < numCourses; i++) {
            inedge.put(i, new HashSet<>());
            outedge.put(i, new HashSet<>());
        }

        for (int[] p : prerequisites) {
            inedge.get(p[0]).add(p[1]);
            outedge.get(p[1]).add(p[0]);
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (inedge.get(i).isEmpty()) queue.add(i);
        }

        int[] res = new int[numCourses];
        int j = 0;
        while (!queue.isEmpty()) {
            int curr = queue.remove();
            res[j++] = curr;
            for (int k : outedge.get(curr)) {
                inedge.get(k).remove(curr);
                if (inedge.get(k).isEmpty())
                    queue.add(k);
            }
        }
        
        if (j != numCourses) return new int[0];

        return res;
    }
}