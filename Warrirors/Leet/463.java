// DFS might have better performance
public class Solution {
    public int islandPerimeter(int[][] grid) {
        int res = 0;
        if (grid.length == 0) return res;
        if (grid[0].length == 0) return res;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0;  j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    if (i == 0) res++;
                    if (i + 1 == grid.length) res++;
                    if (i > 0 && grid[i-1][j] == 0) res++;
                    if (i < grid.length - 1 && grid[i+1][j] == 0) res++;

                    if (j == 0) res++;
                    if (j + 1 == grid[0].length) res++;
                    if (j > 0 && grid[i][j-1] == 0) res++;
                    if (j < grid[0].length - 1 && grid[i][j+1] == 0) res++;
                }
            }
        }

        return res;
    }
}
