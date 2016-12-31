// reference: https://discuss.leetcode.com/topic/5125/sharing-my-simple-c-code-o-n-time-o-1-space
public class Solution {
    public int trap(int[] height) {
        if (height.length == 0) return 0;
        int left = 0, right = height.length - 1;
        int leftMax = 0, rightMax = 0;
        int res = 0;
        while (left <= right) {
            if (height[left] <= height[right]) {
                if (height[left] > leftMax) leftMax = height[left];
                else res += leftMax - height[left];
                left++;
            } else {
                if (height[right] > rightMax) rightMax = height[right];
                else res += rightMax - height[right];
                right--;
            }
        }

        return res;
    }
}
