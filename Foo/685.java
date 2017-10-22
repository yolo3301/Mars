class Solution {
    public int[] findRedundantDirectedConnection(int[][] edges) {
        int len = edges.length;
        int[] parent = new int[len+1];

        // Handle the case when a node has 2 parents
        int[] cand1 = null, cand2 = null;
        for (int i = 0; i < len; i++) {
            int[] e = edges[i];
            if (parent[e[1]] == 0) {
                parent[e[1]] = e[0];
            } else {
                // The first possible invalid edge
                cand1 = new int[] { parent[e[1]], e[1] };
                // The second one, they are in order
                cand2 = new int[] { e[0], e[1] };

                // Invalidate 2nd edge so there won't be a node has 2 parents
                edges[i][1] = 0;
            }
        }

        for (int i = 0; i < len; i++) parent[i] = i;

        // Union find here
        for (int[] e : edges) {
            // Ignore the possible invalidated edge
            if (e[1] == 0) continue;
            int u = e[0], v = e[1], pu = getParent(parent, u);

            if (pu == v) {
                // If there is a circle
                // If no node has 2 parents, then just remove the current edge
                if (cand1 == null) return e;

                // If there is a node with 2 parents
                // cand2 cannot be the in the circle because the edge was invalidated
                // and since there is only 1 invalid edge, it can only be cand1
                // it also implies cand1 is in the circle
                return cand1;
            }

            parent[v] = pu;
        }

        // If there is no circle without cand2 edge
        // then the result is cand2
        return cand2;
    }

    private int getParent(int[] parent, int x) {
        while (parent[x] != x) {
            parent[x] = parent[parent[x]];
            x = parent[x];
        }
        return x;
    }
}

