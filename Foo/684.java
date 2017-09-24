class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        Map<Integer, Integer> root = new HashMap<>();
        // assume there is no duplicate in edges

        int[] res = new int[2];

        for (int[] edge : edges) {
            int p = edge[0];
            int c = edge[1];

            int pr = findRoot(root, p);
            int cr = findRoot(root, c);

            if (pr == cr) {
                res = edge;
            } else {
                root.put(cr, pr);
            }
        }

        return res;
    }

    private int findRoot(Map<Integer, Integer> root, int x) {
        if (!root.containsKey(x)) {
            root.put(x, x);
            return x;
        }

        while (root.get(x) != x) {
            // root[x] = root[root[x]];
            //x = root[x];
            root.put(x, root.get(root.get(x)));
            x = root.get(x);
        }

        return x;
    }
}