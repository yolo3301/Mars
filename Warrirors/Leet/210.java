public class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] ins = new int[numCourses];
        Map<Integer, Set<Integer>> dep = new HashMap<>();

        for (int[] edge : prerequisites) {
            if (!dep.containsKey(edge[1])) {
                dep.put(edge[1], new HashSet<>());
            }
            // In case there are duplicated input!!!
            if (!dep.get(edge[1]).contains(edge[0])) ins[edge[0]]++;
            dep.get(edge[1]).add(edge[0]);
        }

        int[] res = new int[numCourses];
        int index = 0;
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (ins[i] == 0) queue.add(i);
        }

        while (!queue.isEmpty()) {
            int curr = queue.remove();
            res[index++] = curr;
            if (dep.containsKey(curr)) {
                for (Integer d : dep.get(curr)) {
                    ins[d]--;
                    if (ins[d] == 0) queue.add(d);
                }
            }
        }

        if (index < numCourses) return new int[0];

        return res;
    }
}
