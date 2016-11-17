public class Solution {
    public List<int[]> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<int[]> res = new ArrayList<>();
        if (nums1.length == 0 || nums2.length == 0) return res;

        int total = Math.min(k, nums1.length);
        PriorityQueue<int[]> queue = new PriorityQueue<>(total, new Comparator<int[]>() {
            public int compare(int[] a1, int[] a2) {
                return a1[2] - a2[2];
            }
        });
        for (int i = 0; i < total; i++) {
            queue.add(new int[] {i, 0, nums1[i] + nums2[0]});
        }

        for (int i = 0; i < k && !queue.isEmpty(); i++) {
            int[] curr = queue.remove();
            res.add(new int[] {nums1[curr[0]], nums2[curr[1]]});
            if (curr[1] + 1 < nums2.length)
                queue.add(new int[] {curr[0], curr[1] + 1, nums1[curr[0]] + nums2[curr[1] + 1]});
        }

        return res;
    }
}
