/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
public class Solution {
    public int[] findRightInterval(Interval[] intervals) {
        if (intervals.length == 0) return new int[0];
        int[] res = new int[intervals.length];
        TreeMap<Integer, List<Integer>> map = new TreeMap<>();

        for (int i = 0; i < intervals.length; i++) {
            Interval v = intervals[i];
            if (!map.containsKey(v.start)) {
                map.put(v.start, new ArrayList<>());
            }
            map.get(v.start).add(i);
        }

        for (int i = 0; i < intervals.length; i++) {
            Map.Entry<Integer, List<Integer>> entry = map.ceilingEntry(intervals[i].end);
            if (entry == null) {
                res[i] = -1;
            } else {
                for (int j : entry.getValue()) {
                    if (j != i) res[i] = j;
                    break;
                }
            }
        }

        return res;
    }
}