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
    public int minMeetingRooms(Interval[] intervals) {
        // List<int[]> list = new ArrayList<>();
        PriorityQueue<int[]> list = new PriorityQueue<>((a, b) -> {
            if (a[0] != b[0]) return a[0] - b[0];
            else return a[1] - b[1];
        });
        for (Interval v : intervals) {
            list.add(new int[]{v.start, 1});
            list.add(new int[]{v.end, -1});
        }

        /*Collections.sort(list, (a, b) -> {
            if (a[0] != b[0]) return a[0] - b[0];
            else return a[1] - b[1];
        });*/

        int res = 0, con = 0;
        while (!list.isEmpty()) {
            int[] p = list.remove();
            con += p[1];
            res = Math.max(res, con);
        }

        return res;
    }
}