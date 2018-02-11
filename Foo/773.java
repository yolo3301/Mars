class Solution {
    public int slidingPuzzle(int[][] board) {
        Queue<Integer> q = new LinkedList<>();
        int init = key(board);
        int goal = 123450;
        if (init == goal) return 0;

        Set<Integer> visited = new HashSet<>();
        q.add(init);
        int[][] dirs = new int[][]{{1,0},{-1,0},{0,1},{0,-1}};
        int steps = 1;

        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int cur = q.remove();
                int[] zero = new int[2];
                int[][] b = recover(cur, zero);
                for (int[] d : dirs) {
                    int x = zero[0]+d[0];
                    int y = zero[1]+d[1];
                    if (x >= 0 && y >= 0 && x < 2 && y < 3) {
                        swap(b, zero[0], zero[1], x, y);
                        int next = key(b);
                        if (next == goal) return steps;
                        if (!visited.contains(next)) {
                            q.add(next);
                            visited.add(next);
                        }
                        swap(b, zero[0], zero[1], x, y);
                    }
                }
            }
            steps++;
        }

        return -1;
    }

    private void swap(int[][] b, int x1, int y1, int x2, int y2) {
        int tmp = b[x1][y1];
        b[x1][y1] = b[x2][y2];
        b[x2][y2] = tmp;
    }

    private int[][] recover(int k, int[] zero) {
        int[][] b = new int[2][3];
        for (int i = 1; i >= 0; i--) {
            for (int j = 2; j >= 0; j--) {
                b[i][j] = k % 10;
                if (b[i][j] == 0) {
                    zero[0] = i;
                    zero[1] = j;
                }
                k /= 10;
            }
        }
        return b;
    }

    private int key(int[][] board) {
        int k = 0;
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 3; j++) {
                k = k * 10 + board[i][j];
            }
        }
        return k;
    }
}