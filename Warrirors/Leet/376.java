// My solution O(n^2)
public class Solution {
    public int wiggleMaxLength(int[] nums) {
        if (nums.length < 2) return nums.length;
        int[] up = new int[nums.length];
        int[] down = new int[nums.length];
        up[0] = 1;
        down[0] = 1;
        int max = 0;

        for (int i = 1; i < nums.length; i++) {
            up[i] = 1;
            down[i] = 1;
            for (int j = i - 1; j >= 0; j--) {
                if (nums[j] < nums[i]) {
                    up[i] = Math.max(up[i], down[j] + 1);
                } else if (nums[j] > nums[i]) {
                    down[i] = Math.max(down[i], up[j] + 1);
                }
            }
            max = Math.max(max, Math.max(up[i], down[i]));
        }

        return max;
    }
}



// The key is to find the "peak" and "puddle" points
public class Solution {
    public int wiggleMaxLength(int[] nums) {
        if (nums.length < 2) return nums.length;
        int res = 1;
        int i = 1;
        while (i < nums.length) {
            if (nums[i] > nums[i-1]) {
                res++;
                while (i < nums.length && nums[i] >= nums[i-1]) i++;
            } else if (nums[i] < nums[i-1]) {
                res++;
                while (i < nums.length && nums[i] <= nums[i-1]) i++;
            } else {
                i++;
            }
        }
        return res;
    }
}
