public class Solution {
    public int jump(int[] nums) {
        if (nums.length == 0) return 0;
        int board = 0, curr = 0, res = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            board = Math.max(board, i + nums[i]);
            if (curr == i) {
                res++;
                curr = board;
            }
        }

        return res;
    }
}
