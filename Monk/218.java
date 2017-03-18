public class Solution {
    public List<int[]> getSkyline(int[][] buildings) {
        List<int[]> heights = new ArrayList<>();
        for (int[] b : buildings) {
            heights.add(new int[]{b[0], -b[2]});
            heights.add(new int[]{b[1], b[2]});
        }
        Collections.sort(heights, (v1, v2) -> {
            if (v1[0] != v2[0]) return v1[0] - v2[0];
            return v1[1] - v2[1];
        });

        // Map height to count.
        TreeMap<Integer, Integer> bst = new TreeMap<>(Collections.reverseOrder());
        bst.put(0, 1);
        int prevHeight = 0;
        List<int[]> res = new ArrayList<>();

        for (int[] h : heights) {
            if (h[1] < 0) {
                bst.put(-h[1], bst.getOrDefault(-h[1], 0) + 1);
            } else {
                int cnt = bst.get(h[1]);
                if (cnt == 1) bst.remove(h[1]);
                else bst.put(h[1], cnt - 1);
            }

            int curr = bst.firstKey();
            if (curr != prevHeight) {
                res.add(new int[]{h[0], curr});
                prevHeight = curr;
            }
        }

        return res;
    }
}