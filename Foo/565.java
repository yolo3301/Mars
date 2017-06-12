public class Solution {
    public int arrayNesting(int[] nums) {
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < 0) continue;
            int len = 1, val = nums[i];
            while (Math.abs(val) != i) {
                len++;
                val = nums[Math.abs(val)];
                nums[Math.abs(val)] *= -1;
            }
            res = Math.max(res, len);
        }

        return res;
    }
}