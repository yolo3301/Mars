public class Solution {
    public int findCircleNum(int[][] M) {
        int m = M.length;
        if (m <= 1) return m;

        boolean[] visited = new boolean[m];
        int res = 0;
        Queue<Integer> queue = new LinkedList<>();

        for (int i = 0; i < m; i++) {
            if (!visited[i]) {
                res++;
                queue.add(i);
                visited[i] = true;
                while (!queue.isEmpty()) {
                    int curr = queue.remove();
                    for (int j = 0; j < m; j++) {
                        if (M[curr][j] == 1 && curr != j && !visited[j]) {
                            visited[j] = true;
                            queue.add(j);
                        }
                    }
                }
            }
        }

        return res;
    }
}