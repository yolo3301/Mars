public class Solution {
    public List<List<Integer>> updateMatrix(List<List<Integer>> matrix) {
        int m = matrix.size();
        if (m == 0) return matrix;
        int n = matrix.get(0).size();
        if (n == 0) return matrix;
        Queue<int[]> queue = new LinkedList<>();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int dist = matrix.get(i).get(j);
                if (dist == 0) {
                    queue.add(new int[]{i, j});
                } else {
                    matrix.get(i).set(j, Integer.MAX_VALUE);
                }
            }
        }

        int[][] dirs = new int[][]{{0,1},{0,-1},{1,0},{-1,0}};
        while (!queue.isEmpty()) {
            int[] curr = queue.remove();
            for (int[] dir : dirs) {
                int x = curr[0]+dir[0];
                int y = curr[1]+dir[1];
                if (x >= 0 && x < m && y >= 0 && y < n &&
                    matrix.get(x).get(y) > matrix.get(curr[0]).get(curr[1])+1) {
                    matrix.get(x).set(y, matrix.get(curr[0]).get(curr[1])+1);
                    queue.add(new int[]{x, y});
                }
            }
        }

        return matrix;
    }
}