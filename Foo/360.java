public class Solution {
    public int[] sortTransformedArray(int[] nums, int a, int b, int c) {
        int len = nums.length;
        int[] res = new int[len];
        int i = 0, j = len-1;
        int k = (a >= 0) ? len-1 : 0;
        while (i <= j) {
            if (a >= 0) {
                res[k--] = cal(a,b,c,nums[i]) > cal(a,b,c,nums[j]) ? cal(a,b,c,nums[i++]) : cal(a,b,c,nums[j--]);
            } else {
                res[k++] = cal(a,b,c,nums[i]) > cal(a,b,c,nums[j]) ? cal(a,b,c,nums[j--]) : cal(a,b,c,nums[i++]);                
            }
        }
        return res;
    }

    private int cal(int a, int b, int c, int x) {
        return a*x*x + b*x + c;
    }
}