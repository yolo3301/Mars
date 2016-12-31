public class Solution {
    public boolean canJump(int[] nums) {
        if (nums.length == 0) return true;
        int canArrive = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i > canArrive) return false;
            int cand = i + nums[i];
            canArrive = Math.max(canArrive, cand);
        }
        return true;
    }
}
