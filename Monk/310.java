public class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        if (n == 1) {
            List<Integer> res = new ArrayList<>();
            res.add(0);
            return res;
        }
        
        Map<Integer, List<Integer>> neighbor = new HashMap<>();
        for (int[] e : edges) {
            if (!neighbor.containsKey(e[0]))
                neighbor.put(e[0], new ArrayList<>());
            neighbor.get(e[0]).add(e[1]);
            if (!neighbor.containsKey(e[1]))
                neighbor.put(e[1], new ArrayList<>());
            neighbor.get(e[1]).add(e[0]);
        }

        List<Integer> path1 = new ArrayList<>();
        findFurthest(0, neighbor, new boolean[n], new ArrayList<>(), path1);
        List<Integer> path2 = new ArrayList<>();
        findFurthest(path1.get(path1.size() - 1), neighbor, new boolean[n], new ArrayList<>(), path2);

        List<Integer> res = new ArrayList<>();

        res.add(path2.get((path2.size() - 1) / 2));
        if (path2.size() % 2 == 0) res.add(path2.get(path2.size() / 2));

        return res;
    }

    private void findFurthest(int curr, Map<Integer, List<Integer>> neighbor,
        boolean[] discovered, List<Integer> path, List<Integer> res) {
        if (discovered[curr]) return;

        discovered[curr] = true;
        path.add(curr);

        if (path.size() > res.size()) {
            res.clear();
            res.addAll(path);
        }

        for (int n : neighbor.get(curr)) {
            findFurthest(n, neighbor, discovered, path, res);
        }
        
        path.remove(path.size() - 1);
    }
}