public class Solution {
    public class Result {
        public String str;
        public double val;
    }

    public String optimalDivision(int[] nums) {
        Result res = getMax(nums, 0, nums.length-1);
        return res.str;
    }

    private double getMax(int[] nums, int s, int e) {
        Result res = new Result();
        res.val = -1.0;

        if (s == e) {
            res.val = (double)nums[s];
            res.str = nums[s] + "";
        } else if (s + 1 == e) {
            res.val = (double)nums[s] / nums[e];
            res.str = nums[s] + "/" + nums[e];
        } else {
            for (int i = s; i < e; i++) {
                Result left = getMax(nums, s, i);
                Result right = getMin(nums, i+1, e);
                if (left.val / right.val > res.val) {
                    res.val = left.val / right.val;
                    res.str = left.str + "/" + (i+2 <= e ? "("+right.str+")" : right.str);
                }
            }
        }

        return res;
    }

    private double getMin(int[] nums, int s, int e) {
        Result res = new Result();
        res.val = Double.MAX_VALUE;

        if (s == e) {
            res.val = (double)nums[s];
            res.str = nums[s] + "";
        } else if (s + 1 == e) {
            res.val = (double)nums[s] / nums[e];
            res.str = nums[s] + "/" + nums[e];
        } else {
            for (int i = s; i < e; i++) {
                Result left = getMin(nums, s, i);
                Result right = getMax(nums, i+1, e);
                if (left.val / right.val < res.val) {
                    res.val = left.val / right.val;
                    res.str = left.str + "/" + (i+2 <= e ? "("+right.str+")" : right.str);
                }
            }
        }

        return res;
    }
}