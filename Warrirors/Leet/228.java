public class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> res = new ArrayList<>();
        if (nums.length == 0) return res;
        int s = 0, e = 1;
        for (e = 1; e < nums.length; e++) {
            if (nums[e] > 1 + nums[e-1]) {
                if (e - 1 > s) {
                    res.add(nums[s] + "->" + nums[e-1]);
                } else {
                    res.add(Integer.toString(nums[s]));
                }
                s = e;
            }
        }

        if (s < nums.length - 1) {
            res.add(nums[s] + "->" + nums[nums.length - 1]);
        } else {
            res.add(Integer.toString(nums[s]));
        }

        return res;
    }
}
