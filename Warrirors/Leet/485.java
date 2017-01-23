public class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int cnt = 0, res = 0;
        for (int i : nums) {
            if (i == 1) cnt++;
            else {
                res = Math.max(res, cnt);
                cnt = 0;
            }
        }

        res = Math.max(res, cnt);

        return res;
    }
}
