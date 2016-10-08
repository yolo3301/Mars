public class Solution {
    public List<Integer> topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> count = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (count.containsKey(nums[i])) {
                count.put(nums[i], count.get(nums[i]) + 1);
            } else {
                count.put(nums[i], 1);
            }
        }

        Queue<Map.Entry<Integer, Integer>> heap = new PriorityQueue<>(nums.length, new Comparator<Map.Entry<Integer, Integer>>() {
            public int compare(Map.Entry<Integer, Integer> e1, Map.Entry<Integer, Integer> e2) {
                return e2.getValue() - e1.getValue();
            }
        });
        for (Map.Entry<Integer, Integer> e : count.entrySet()) {
            heap.add(e);
        }

        List<Integer> res = new ArrayList<>();
        while (!heap.isEmpty() && res.size() < k) {
            res.add(heap.remove().getKey());
        }

        return res;
    }
}
