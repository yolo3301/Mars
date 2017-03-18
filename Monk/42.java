public class Solution {
    public int trap(int[] height) {
        int leftMax = 0;
        int[] potential = new int[height.length];
        for (int i = 0; i < height.length; i++) {
            potential[i] = leftMax;
            leftMax = Math.max(leftMax, height[i]);
        }

        int rightMax = 0, res = 0;
        for (int i = height.length - 1; i >= 0; i--) {
            res += Math.max(0, Math.min(rightMax, potential[i]) - height[i]);
            rightMax = Math.max(rightMax, height[i]);
        }

        return res;
    }
}