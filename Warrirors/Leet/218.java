public class Solution {
    public List<int[]> getSkyline(int[][] buildings) {
        List<int[]> heights = new ArrayList<>();
        // Mark height as negative to diff start and end points
        for (int[] b : buildings) {
            heights.add(new int[] { b[0], -b[2] });
            heights.add(new int[] { b[1], b[2] });
        }
        Collections.sort(heights, (v1, v2) -> {
            if (v1[0] != v2[0]) return v1[0] - v2[0];
            return v1[1] - v2[1];
        });
        TreeMap<Integer, Integer> ph = new TreeMap<>(Collections.reverseOrder());
        ph.put(0, 1);  // initial height
        int prev = 0;  // previous height
        List<int[]> res = new ArrayList<>();
        for (int[] h : heights) {
            if (h[1] < 0) {  // if it's a start point, add the height
                Integer cnt = ph.get(-h[1]);
                cnt = (cnt == null) ? 1 : cnt + 1;
                ph.put(-h[1], cnt);
            } else {  // if it's end point, remove the height
                Integer cnt = ph.get(h[1]);
                if (cnt == 1) {
                    ph.remove(h[1]);
                } else {
                    ph.put(h[1], cnt - 1);
                }
            }

            // get current max height
            int curr = ph.firstKey();
            if (curr != prev) {
                res.add(new int[] { h[0], curr });
                prev = curr;
            }
        }

        return res;
    }
}
