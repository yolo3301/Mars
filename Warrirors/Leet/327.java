// more efficient solution with 1. merge sort; 2. sort first, then binary search
public class Solution {
    public int countRangeSum(int[] nums, int lower, int upper) {
        if (nums.length == 0) return 0;

        long sum = 0;
        int count = 0;
        TreeMap<Long, Integer> bst = new TreeMap<>();
        // This is important !!!
        bst.put(0l, 1);

        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];

            Map<Long, Integer> submap = bst.subMap(sum-upper, true, sum-lower, true);
            for (Integer c : submap.values()) {
                count += c;
            }

            if (bst.containsKey(sum)) {
                bst.put(sum, bst.get(sum) + 1);
            } else {
                bst.put(sum, 1);
            }
        }

        return count;
    }
}
