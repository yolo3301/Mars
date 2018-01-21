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
    public List<Interval> employeeFreeTime(List<List<Interval>> schedule) {
        List<Interval> ret = new ArrayList<>();
        PriorityQueue<int[]> heap = new PriorityQueue<>((a, b) -> {
            if (a[0] == b[0]) return b[1] - a[1];
            return a[0] - b[0];
        });

        for (int i = 0; i < schedule.size(); i++) {
            Interval cur = schedule.get(i).get(0);
            heap.add(new int[]{cur.start, cur.end, i, 0});
        }

        int prevEnd = -1;
        while (!heap.isEmpty()) {
            int[] cur = heap.remove();
            //System.out.println(Arrays.toString(cur));
            int nextIndex = cur[3]+1;
            if (schedule.get(cur[2]).size() > nextIndex) {
                Interval next = schedule.get(cur[2]).get(nextIndex);
                //System.out.println("Adding: " + next.start + " " + next.end);
                heap.add(new int[]{next.start, next.end, cur[2], nextIndex});
            }

            if (prevEnd != -1 && cur[0] > prevEnd) {
                ret.add(new Interval(prevEnd, cur[0]));
            }

            prevEnd = Math.max(prevEnd, cur[1]);
        }

        return ret;
    }
}