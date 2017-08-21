class Solution {
    public boolean isPossible(int[] nums) {
        // last num to len
        Map<Integer, PriorityQueue<Integer>> map = new HashMap<>();
        int needMore = 0;

        for (int i : nums) {
            int len = 0;
            if (map.containsKey(i-1) && !map.get(i-1).isEmpty()) {
                len = map.get(i-1).remove();
            }

            if (!map.containsKey(i)) {
                map.put(i, new PriorityQueue<>());
            }
            map.get(i).add(len+1);

            if (len == 0) needMore++;
            else if (len+1 == 3) needMore--;
        }

        return needMore == 0;
    }
}