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
        int s = newInterval.start, e = newInterval.end;

        if (intervals.isEmpty()) {
            res.add(newInterval);
            return res;
        }

        if (e < intervals.get(0).start) {
            res.add(newInterval);
            res.addAll(intervals);
            return res;
        } else if (s > intervals.get(intervals.size() - 1).end) {
            res.addAll(intervals);
            res.add(newInterval);
            return res;
        }

        int i = 0;

        if (s < intervals.get(0).start && e >= intervals.get(0).start) {
            int j = i, ine = e;
            while (j < intervals.size() && ine >= intervals.get(j).start) {
                ine = Math.max(ine, intervals.get(j++).end);
            }
            res.add(new Interval(s, ine));
            i = j;
        }

        while (i < intervals.size()) {
            if (s >= intervals.get(i).start && (i + 1 >= intervals.size() || s < intervals.get(i + 1).start)) {
                if (e <= intervals.get(i).end) {
                    res.add(intervals.get(i++));
                } else {
                    int ins = intervals.get(i).start;
                    int ine = e;
                    if (s > intervals.get(i).end) {
                        res.add(intervals.get(i));
                        ins = s;
                    }
                    int j = i;
                    while (j < intervals.size() && ine >= intervals.get(j).start) {
                        ine = Math.max(ine, intervals.get(j++).end);
                    }
                    res.add(new Interval(ins, ine));
                    i = j;
                }
            } else {
                res.add(intervals.get(i++));
            }
        }

        return res;
    }
}
