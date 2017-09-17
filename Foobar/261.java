class Solution {
    // use union find
    public boolean validTree(int n, int[][] edges) {
        int[] root = new int[n];
        Arrays.fill(root, -1);

        for (int[] e : edges) {
            int r1 = findRoot(e[0], root);
            int r2 = findRoot(e[1], root);

            if (r1 == r2) return false;

            root[r1] = r2;
        }

        return edges.length == n-1; // important! 
    }

    private int findRoot(int x, int[] root) {
        if (root[x] == -1) {
            root[x] = x;
            return x;
        }

        while (root[x] != x) {
            root[x] = root[root[x]]; // a way to optimize
            x = root[x];
        }

        return x;
    }
}