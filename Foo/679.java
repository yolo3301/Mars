class Solution {
    public boolean judgePoint24(int[] nums) {
        int[][] order = new int[][] {
            {0, 1, 2, 3},
            {0, 1, 3, 2},
            {0, 2, 1, 3},
            {0, 2, 3, 1},
            {0, 3, 1, 2},
            {0, 3, 2, 1},
            {1, 0, 2, 3},
            {1, 0, 3, 2},
            {1, 2, 0, 3},
            {1, 2, 3, 0},
            {1, 3, 0, 2},
            {1, 3, 2, 0},
            {2, 0, 1, 3},
            {2, 0, 3, 1},
            {2, 1, 0, 3},
            {2, 1, 3, 0},
            {2, 3, 0, 1},
            {2, 3, 1, 0},
            {3, 0, 1, 2},
            {3, 0, 2, 1},
            {3, 1, 0, 2},
            {3, 1, 2, 0},
            {3, 2, 0, 1},
            {3, 2, 1, 0},
        };

        for (int i = 0; i < 24; i++) {
            Set<Double> list = bt(nums, order[i], 0, 3);
            for (double d : list) if (Math.abs(d - 24.0) < 0.00000001) return true;
        }

        return false;
    }

    private Set<Double> bt(int[] nums, int[] order, int s, int e) {
        Set<Double> res = new HashSet<>();
        if (s == e) {
            res.add((double)nums[order[s]]);
            return res;
        }

        for (int i = s; i < e; i++) {
            for (double left : bt(nums, order, s, i)) {
                for (double right : bt(nums, order, i+1, e)) {
                    res.add(left + right);
                    res.add(left - right);
                    res.add(left * right);
                    if (right != 0) res.add(left / right);
                }
            }
        }

        return res;
    }
}