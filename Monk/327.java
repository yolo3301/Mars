import java.util.*;

public class Solution {
    public int countRangeSum(int[] nums, int lower, int upper) {
        TreeMap<Long, Integer> map = new TreeMap<>();
        map.put(0l, 1);

        int sum = 0, res = 0;

        for (int i : nums) {
            sum += i;

            NavigableMap<Long, Integer> sub = map.subMap(sum - upper, true, sum - lower, true);
            for (Map.Entry<Long, Integer> e : sub.entrySet()) {
                res += e.getValue();
            }

            int cnt = map.getOrDefault(sum, 0);
            map.put(sum, cnt + 1);
        }

        return res;
    }
}