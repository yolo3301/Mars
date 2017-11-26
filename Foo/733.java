class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int curColor = image[sr][sc];
        if (curColor == newColor) return image;
        fill(image, sr, sc, curColor, newColor);
        return image;
    }

    private void fill(int[][] image, int x, int y, int curColor, int newColor) {
        if (x<0 || x>=image.length || y<0 || y>=image[0].length || image[x][y] != curColor)
            return;

        image[x][y] = newColor;

        fill(image, x+1, y, curColor, newColor);
        fill(image, x-1, y, curColor, newColor);
        fill(image, x, y+1, curColor, newColor);
        fill(image, x, y-1, curColor, newColor);
    }
}