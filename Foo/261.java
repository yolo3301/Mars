public class Solution {
    public boolean validTree(int n, int[][] edges) {
        int[] root = new int[n];
        Arrays.fill(root, -1);

        List<Integer>[] neighbor = new ArrayList[n];
        for (int[] e : edges) {
            if (neighbor[e[0]] == null) neighbor[e[0]] = new ArrayList<>();
            if (neighbor[e[1]] == null) neighbor[e[1]] = new ArrayList<>();
            neighbor[e[0]].add(e[1]);
            neighbor[e[1]].add(e[0]);
        }

        int cnt = 0;
        for (int i = 0; i < n; i++) {
            root[i] = i;
            cnt++;
            int r = i;
            
            if (neighbor[i] == null) continue;
            for (int m : neighbor[i]) {
                if (root[m] != -1) {
                    int j = getRoot(m, root);
                    if (j == r) return false;
                    root[r] = j;
                    r = j;
                    cnt--;
                }
            }
        }

        return cnt == 1;
    }

    private int getRoot(int i, int[] root) {
        while (root[i] != i) {
            root[i] = root[root[i]];
            i = root[i];
        }
        return i;
    }
}