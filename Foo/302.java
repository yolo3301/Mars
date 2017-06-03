public class Solution {

    int maxX = Integer.MIN_VALUE;
    int maxY = Integer.MIN_VALUE;
    int minX = Integer.MAX_VALUE;
    int minY = Integer.MAX_VALUE;

    public int minArea(char[][] image, int x, int y) {
        int m = image.length;
        if (m == 0) return 0;
        int n = image[0].length;
        if (n == 0) return 0;

        dfs(image, x, y, m, n);

        return (maxX - minX + 1) * (maxY - minY + 1);
    }

    private void dfs(char[][] image, int x, int y, int m, int n) {
        if (x < 0 || x >= m || y < 0 || y >= n || image[x][y] != '1')
            return;

        maxX = Math.max(maxX, x);
        maxY = Math.max(maxY, y);
        minX = Math.min(minX, x);
        minY = Math.min(minY, y);

        image[x][y] = 'x';

        dfs(image, x+1, y, m, n);
        dfs(image, x-1, y, m, n);
        dfs(image, x, y+1, m, n);
        dfs(image, x, y-1, m, n);

        image[x][y] = '1';
    }
}

public class Solution {
    public int minArea(char[][] image, int x, int y) {
        int left = leftmost(image, 0, y, true);
        int right = rightmost(image, y, image[0].length-1, true);
        int top = leftmost(image, 0, x, false);
        int bottom = rightmost(image, x, image.length-1, false);

        return (right - left + 1) * (bottom - top + 1);
    }

    private int leftmost(char[][] image, int min, int max, boolean horizontal) {
        int l = min, r = max;
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (hasBlack(image, mid, horizontal)) {
                r = mid;
            } else {
                l = mid+1;
            }
        }
        return l;
    }

    private int rightmost(char[][] image, int min, int max, boolean horizontal) {
        int l = min, r = max;
        while (l < r) {
            int mid = l + (r - l + 1) / 2;
            if (hasBlack(image, mid, horizontal)) {
                l = mid;
            } else {
                r = mid-1;
            }
        }
        return r;
    }

    private boolean hasBlack(char[][] image, int mid, boolean horizontal) {
        if (!horizontal) {
            for (int i = 0; i < image[0].length; i++) {
                if (image[mid][i] == '1')
                    return true;
            }
            return false;
        } else {
            for (int i = 0; i < image.length; i++) {
                if (image[i][mid] == '1')
                    return true;
            }
            return false;
        }
    }
}