public class Solution {
    public boolean canPartition(int[] nums) {
        if (nums == null || nums.length == 0) return true;
        int total = 0;
        for (int i = 0; i < nums.length; i++) {
            total += nums[i];
        }

        if (total % 2 != 0) return false;

        return sumToK(nums, total / 2);
    }

    private boolean sumToK(int[] nums, int target) {
        // means select from first i elements
        // to sum up to j
        boolean[][] mem = new boolean[nums.length + 1][target + 1];

        // when select 0 elements, always false
        for (int i = 0; i <= target; i++) {
            mem[0][i] = false;
        }
        // when j = 0, we don't need to select any, so always true
        for (int i = 0; i <= nums.length; i++) {
            mem[i][0] = true;
        }

        for (int i = 1; i <= nums.length; i++) {
            for (int j = 1; j <= target; j++) {
                mem[i][j] = mem[i-1][j];
                if (j - nums[i-1] >= 0) {
                    mem[i][j] |= mem[i-1][j-nums[i-1]];
                }
            }
        }

        return mem[nums.length][target];
    }
}
