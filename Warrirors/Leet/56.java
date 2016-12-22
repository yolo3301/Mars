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
    public List<Interval> merge(List<Interval> intervals) {
        Collections.sort(intervals, new Comparator<Interval>() {
            public int compare(Interval v1, Interval v2) {
                if (v1.start != v2.start) return v1.start - v2.start;
                return v1.end - v2.end;
            }
        });

        List<Interval> res = new ArrayList<>();
        int i = 0;
        while (i < intervals.size()) {
            Interval curr = intervals.get(i);
            int boarder = curr.end;
            int j = i + 1;
            while (j < intervals.size() && intervals.get(j).start <= boarder) {
                boarder = Math.max(boarder, intervals.get(j).end);
                j++;
            }

            curr.end = boarder;
            res.add(curr);

            i = j;
        }

        return res;
    }
}
