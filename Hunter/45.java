public class Solution {
    public int jump(int[] nums) {
        if (nums.length <= 1) return 0;
        int curr = 0, board = 0, step = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            board = Math.max(board, i + nums[i]);
            if (i >= curr) {
                step++;
                curr = board;
            }
        }

        return step;
    }
}