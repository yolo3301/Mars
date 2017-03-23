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
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        List<Interval> res = new ArrayList<>();

        if (intervals.isEmpty()) {
            res.add(newInterval);
            return res;
        }

        if (newInterval.end < intervals.get(0).start) {
            res.add(newInterval);
            res.addAll(intervals);
            return res;
        }

        if (newInterval.start > intervals.get(intervals.size() - 1).end) {
            res.addAll(intervals);
            res.add(newInterval);
            return res;
        }

        int i = 0;
        while (i < intervals.size() && intervals.get(i).end < newInterval.start) {
            res.add(intervals.get(i++));
        }

        int newStart = Math.min(intervals.get(i).start, newInterval.start);
        int j = i;
        while (j < intervals.size() && intervals.get(j).start <= newInterval.end) {
            j++;
        }

        if (j == i) {
            res.add(newInterval);
        } else {
            int newEnd = Math.max(intervals.get(j-1).end, newInterval.end);
            res.add(new Interval(newStart, newEnd));
            i = j;
        }

        while (i < intervals.size()) {
            res.add(intervals.get(i++));
        }

        return res;
    }
}