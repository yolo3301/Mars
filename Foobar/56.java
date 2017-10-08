/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
class Solution {
    public List<Interval> merge(List<Interval> intervals) {
        List<Interval> ret = new ArrayList<>();
        if (intervals.isEmpty()) return ret;

        Collections.sort(intervals, (a, b) -> {
            if (a.start != b.start) return a.start - b.start;
            return b.end - a.end;
        });

        for (int i = 0; i < intervals.size(); ) {
            int end = intervals.get(i).end;
            int j = i+1;
            while (j < intervals.size() && intervals.get(j).start <= end) {
                end = Math.max(end, intervals.get(j++).end);
            }
            ret.add(new Interval(intervals.get(i).start, end));
            i = j;
        }

        return ret;
    }
}
