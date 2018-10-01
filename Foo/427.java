/*
// Definition for a QuadTree node.
class Node {
    public boolean val;
    public boolean isLeaf;
    public Node topLeft;
    public Node topRight;
    public Node bottomLeft;
    public Node bottomRight;

    public Node() {}

    public Node(boolean _val,boolean _isLeaf,Node _topLeft,Node _topRight,Node _bottomLeft,Node _bottomRight) {
        val = _val;
        isLeaf = _isLeaf;
        topLeft = _topLeft;
        topRight = _topRight;
        bottomLeft = _bottomLeft;
        bottomRight = _bottomRight;
    }
};
*/
class Solution {
    public Node construct(int[][] grid) {
        int n = grid.length;
        int[][] row = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0) row[i][j] = grid[0][j];
                else row[i][j] = row[i-1][j]+grid[i][j];
            }
        }
        int[][] sum = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (j == 0) sum[i][j] = row[i][0];
                else sum[i][j] = sum[i][j-1]+row[i][j];
            }
        }
        return helper(sum, new int[]{0,0}, new int[]{n-1, n-1});
    }

    private Node helper(int[][] sum, int[] s, int[] e) {
        int expect = (e[0]-s[0]+1)*(e[0]-s[0]+1);
        int got = size(sum, s, e);
        if (got == 0) {
            return new Node(false, true, null, null, null, null);
        }
        if (got == expect) {
            return new Node(true, true, null, null, null, null);
        }

        int m1 = s[0] + (e[0]-s[0]) / 2;
        int m2 = s[1] + (e[1]-s[1]) / 2;
        Node ret = new Node(false, false, null, null, null, null);
        ret.topLeft = helper(sum, s, new int[]{m1, m2});
        ret.topRight = helper(sum, new int[]{s[0], m2+1}, new int[]{m1, e[1]});
        ret.bottomLeft = helper(sum, new int[]{m1+1, s[1]}, new int[]{e[0], m2});
        ret.bottomRight = helper(sum, new int[]{m1+1, m2+1}, e);
        return ret;
    }

    private int size(int[][] sum, int[] s, int[] e) {
        int z1 = 0;
        if (s[0]-1 >= 0) z1 = sum[s[0]-1][e[1]];
        int z2 = 0;
        if (s[1]-1 >= 0) z2 = sum[e[0]][s[1]-1];
        int z3 = 0;
        if (s[0]-1>=0 && s[1]-1>=0) z3 = sum[s[0]-1][s[1]-1];
        return sum[e[0]][e[1]] - z1 - z2 + z3;
    }
}