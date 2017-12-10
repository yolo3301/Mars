class Solution {
    public boolean judgePoint24(int[] nums) {
        return iterateOrder(nums, 0);
    }

    private boolean iterateOrder(int[] nums, int index) {
        if (index == nums.length) {
            Set<Double> set = cal(nums, 0, 3);
            for (double d : set)
                if (Math.abs(d - 24.0) < 0.0000001)
                    return true;
            return false;
        }

        boolean ret = false;
        for (int i = index; i < nums.length; i++) {
            swap(nums, i, index);
            ret |= iterateOrder(nums, index+1);
            swap(nums, i, index);
            if (ret) return true;
        }

        return ret;
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    private Set<Double> cal(int[] nums, int s, int e) {
        Set<Double> ret = new HashSet<>();
        if (s == e) {
            ret.add((double)nums[s]);
            return ret;
        }

        for (int i = s; i < e; i++) {
            Set<Double> left = cal(nums, s, i);
            Set<Double> right = cal(nums, i+1, e);
            for (double d1 : left) {
                for (double d2 : right) {
                    ret.add(d1 + d2);
                    ret.add(d1 * d2);
                    ret.add(d1 - d2);
                    if (d2 != 0) ret.add(d1 / d2);
                }
            }
        }

        return ret;
    }
}