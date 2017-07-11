public class Solution {
    public boolean judgeSquareSum(int c) {
        if (c < 0) return false;
        if (c == 0) return true;
        
        int left = 0, right = Math.sqrt(c);
        while (left <= right) {
            int cand = left*left + right*right;
            if (cand > c) {
                right--;
            } else if (cand < c) {
                left++;
            } else {
                return true;
            }
        }

        return false;
    }
}