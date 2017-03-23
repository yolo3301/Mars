public class Solution {
    public int jump(int[] nums) {
        int res = 0, board = 0, prevBoard = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            board = Math.max(board, nums[i] + i);
            if (i == prevBoard) {
                res++;
                prevBoard = board;
            }
        }

        return res;
    }
}