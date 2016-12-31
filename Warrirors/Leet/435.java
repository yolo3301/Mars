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
    public int eraseOverlapIntervals(Interval[] intervals) {
        if (intervals.length <= 1) return 0;
        Arrays.sort(intervals, new Comparator<Interval>() {
            public int compare(Interval v1, Interval v2) {
                if (v1.end != v2.end) {
                    return v1.end - v2.end;
                } else {
                    return v1.start - v2.start;
                }
            }
        });

        int res = 0;
        for (int i = 0; i < intervals.length; ) {
            for (int j = i + 1; j < intervals.length; j++) {
                if (intervals[j].start < intervals[i].end) {
                    res++;
                } else {
                    break;
                }
            }
            i = j;
        }

        return res;
    }
}
