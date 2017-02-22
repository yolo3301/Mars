public class Solution {
    public List<Integer> topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> cnt = new HashMap<>();
        for (int i : nums) {
            if (cnt.containsKey(i)) {
                cnt.put(i, cnt.get(i) + 1);
            } else {
                cnt.put(i, 1);
            }
        }

        PriorityQueue<int[]> q = new PriorityQueue<>(new Comparator<int[]>() {
            public int compare(int[] v1, int[] v2) {
                return v2[1] - v1[1];
            }
        });
        for (Map.Entry<Integer, Integer> entry : cnt.entrySet()) {
            q.add(new int[] {entry.getKey(), entry.getValue()});
        }

        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            res.add(q.remove()[0]);
        }

        return res;
    }
}