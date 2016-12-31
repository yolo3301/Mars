/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
public class SummaryRanges {

    private List<Interval> intervals;

    /** Initialize your data structure here. */
    public SummaryRanges() {
        intervals = new ArrayList<>();
    }

    public void addNum(int val) {
        if (intervals.isEmpty()) {
            intervals.add(new Interval(val, val));
        } else {
            int insertIndex = search(val, 0, intervals.size() - 1);

            Interval v1 = insertIndex >= 0 ? intervals.get(insertIndex) : null;
            Interval v2 = insertIndex + 1 < intervals.size() ? intervals.get(insertIndex + 1) : null;

            if (v1 != null && v2 == null) {
                if (val >= v1.start && val <= v1.end) return;
                else if (val == v1.end + 1) v1.end = val;
                else intervals.add(insertIndex + 1, new Interval(val, val));
            } else if (v1 == null && v2 != null) {
                if (val + 1 == v2.start) v2.start = val;
                else intervals.add(0, new Interval(val, val));
            } else {
                if (val >= v1.start && val <= v1.end) return;
                else if (val == v1.end + 1) {
                    v1.end = val;
                    if (v2.start == val + 1) {
                        v1.end = v2.end;
                        intervals.remove(insertIndex + 1);
                    }
                } else if (v2.start == val + 1) v2.start = val;
                else intervals.add(insertIndex + 1, new Interval(val, val));
            }
        }
    }
    
    public List<Interval> getIntervals() {
        return intervals;
    }

    private int search(int val, int s, int e) {
        if (s > e) return e;

        int m = s + (e - s) / 2;
        Interval curr = intervals.get(m);

        if (val >= curr.start) {
            if (m + 1 > e || m + 1 <= e && intervals.get(m+1).start > val)
                return m;
            else
                return search(val, m + 1, e);
        } else {
            return search(val, s, m - 1);
        }
    }
}

/**
 * Your SummaryRanges object will be instantiated and called as such:
 * SummaryRanges obj = new SummaryRanges();
 * obj.addNum(val);
 * List<Interval> param_2 = obj.getIntervals();
 */
