class Solution {
    public int intersectionSizeTwo(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> {
            if (a[0] == b[0]) return b[1]-a[1];
            return a[0]-b[0];
        });

        Deque<int[]> deq = new LinkedList<>();
        for (int[] v : intervals) {
            while (!deq.isEmpty() && v[1] <= deq.getLast()[1])
                deq.removeLast();
            deq.addLast(v);
        }

        int ret = 2;
        int r1 = deq.getFirst()[1]-1, r2 = deq.getFirst()[1];
        deq.removeFirst();

        while (!deq.isEmpty()) {
            int[] cur = deq.removeFirst();
            boolean b1 = (cur[0] <= r1 && r1 <= cur[1]);
            boolean b2 = (cur[0] <= r2 && r2 <= cur[1]);

            if (b1 && b2) continue;

            if (b2) {
                r1 = r2;
                r2 = cur[1];
                ret++;
            } else {
                r1 = cur[1]-1;
                r2 = cur[1];
                ret += 2;
            }
        }

        return ret;
    }
}