class Solution {
    public int[] sortTransformedArray(int[] nums, int a, int b, int c) {
        int i = 0, j = nums.length-1;
        int k = (a >= 0) ? nums.length-1 : 0;
        int[] res = new int[nums.length];

        while (i <= j) {
            if (a >= 0) {
                res[k--] = cal(nums, a, b, c, i) > cal(nums, a, b, c, j) ? cal(nums, a, b, c, i++) : cal(nums, a, b, c, j--);
            } else {
                res[k++] = cal(nums, a, b, c, i) < cal(nums, a, b, c, j) ? cal(nums, a, b, c, i++) : cal(nums, a, b, c, j--);
            }
        }
        return res;
    }

    private int cal(int[] nums, int a, int b, int c, int index) {
        int x = nums[index];
        return a*x*x + b*x + c;
    }
}