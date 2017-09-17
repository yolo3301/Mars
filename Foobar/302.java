class Solution {
    public int minArea(char[][] image, int x, int y) {
        int m = image.length;
        if (m == 0) return 0;
        int n = image[0].length;
        if (n == 0) return 0;
        
        l = r = x;
        t = b = y;
        flood(image, new boolean[m][n], x, y);
        
        // System.out.println(l + " " + r + " " + t + " " + b);

        return (r - l + 1) * (b - t + 1);
    }

    int l, r, t, b;

    private void flood(char[][] image, boolean[][] visited, int x, int y) {
        int[][] dirs = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{x, y});
        visited[x][y] = true;

        while (!q.isEmpty()) {
            int[] curr = q.remove();
            for (int[] d : dirs) {
                int nx = curr[0]+d[0];
                int ny = curr[1]+d[1];
                if (nx >= 0 && nx < image.length && ny >= 0 && ny < image[0].length && image[nx][ny] == '1' && !visited[nx][ny]) {
                    visited[nx][ny] = true;
                    l = Math.min(l, nx);
                    r = Math.max(r, nx);
                    t = Math.min(t, ny);
                    b = Math.max(b, ny);
                    q.add(new int[]{nx, ny});
                }
            }
        }
    }
}

class Solution {
    public int minArea(char[][] image, int x, int y) {
        int l = leftMost(image, 0, y, true);
        int r = rightMost(image, y, image[0].length-1, true);
        int t = leftMost(image, 0, x, false);
        int b = rightMost(image, x, image.length-1, false);

        return (r - l + 1) * (b - t + 1);
    }

    private int leftMost(char[][] image, int min, int max, boolean horizontal) {
        int l = min, r = max;
        while (l < r) {
            int m = l + (r - l) / 2;
            if (hasBlack(image, m, horizontal)) {
                r = m;
            } else {
                l = m+1;
            }
        }

        return l;
    }

    private int rightMost(char[][] image, int min, int max, boolean horizontal) {
        int l = min, r = max;
        while (l < r) {
            int m = l + (r - l + 1) / 2; // Important! Otherwise infinite loop
            if (hasBlack(image, m, horizontal)) {
                l = m;
            } else {
                r = m-1;
            }
        }

        return r;
    }

    private boolean hasBlack(char[][] image, int x, boolean horizontal) {
        if (horizontal) {
            for (int i = 0; i < image.length; i++) {
                if (image[i][x] == '1') return true;
            }
        } else {
            for (int i = 0; i < image[0].length; i++) {
                if (image[x][i] == '1') return true;
            }
        }
        return false;
    }
}