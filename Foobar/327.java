import java.util.*;

class Solution {
    public int countRangeSum(int[] nums, int lower, int upper) {
        TreeMap<Long, Integer> map = new TreeMap<>();
        map.put(0l, 1);
        long acc = 0;

        int ret = 0;

        for (int n : nums) {
            acc += n;
            
            NavigableMap<Long, Integer> sub = map.subMap(acc - upper, true, acc - lower, true);
            for (Map.Entry<Long, Integer> e : sub.entrySet()) {
                ret += e.getValue();
            }

            map.put(acc, map.getOrDefault(acc, 0) + 1);
        }

        return ret;
    }
}

// There is another merge sort solution