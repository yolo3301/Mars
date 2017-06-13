public class Solution {
    public int minDistance(int height, int width, int[] tree, int[] squirrel, int[][] nuts) {
        int total = 0;
        for (int[] nut : nuts) {
            total += 2 * dist(tree, nut);
        }

        int res = Integer.MAX_VALUE;
        for (int[] nut : nuts) {
            int squirrelToNut = dist(squirrel, nut);
            int treeToNut = dist(tree, nut);
            res = Math.min(res, total - treeToNut + squirrelToNut);
        }

        return res;
    }

    private int dist(int[] start, int[] end) {
        return Math.abs(start[0]-end[0]) + Math.abs(start[1]-end[1]);
    }
}