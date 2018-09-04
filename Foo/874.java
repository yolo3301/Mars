class Solution {
    public int robotSim(int[] commands, int[][] obstacles) {
        int x = 0, y = 0;
        int[][] dirs = new int[][]{{0, 1},{1, 0},{0, -1},{-1, 0}};
        int d = 0;

        Set<String> set = new HashSet<>();
        for (int[] o : obstacles) {
            set.add(Integer.toString(o[0]) + " " + Integer.toString(o[1]));
        }

        int ret = 0;
        for (int c : commands) {
            if (c < 0) {
                if (c == -2) {
                    if (--d < 0) d = 3;
                } else {
                    if (++d > 3) d = 0;
                }
            } else {
                for (int i = 0; i < c; i++) {
                    if (set.contains(Integer.toString(x+dirs[d][0]) + " " + Integer.toString(y+dirs[d][1]))) {
                        break;
                    } else {
                        x += dirs[d][0];
                        y += dirs[d][1];
                        ret = Math.max(ret, x*x + y*y);
                    }
                }
            }
        }

        return ret;
    }
}