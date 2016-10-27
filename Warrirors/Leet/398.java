public class Solution {

    private int[] nums;

    public Solution(int[] nums) {
        this.nums = nums;
    }

    public int pick(int target) {
        int j = 0;
        int res = 0;
        Random r = new Random();
        for (int i = 0; i < nums.length; i++) {
            if (target == nums[i]) {
                j++;
                if (r.nextInt(j) == 0) {
                    res = i;
                }
            }
        }

        return res;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int param_1 = obj.pick(target);
 */
