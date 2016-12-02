/*
Container With Most Water

Given n non-negative integers a1, a2, ..., an, where each represents a point at coordinate (i, ai). n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0). Find two lines, which together with x-axis forms a container, such that the container contains the most water.

Note: You may not slant the container.
*/

public class Solution {
    public int maxArea(int[] height) {
        int start = 0;
        int end = height.length - 1;
        int max = 0;
        while (start < end) {
            max = Math.max(max, calcWater(height, start, end));
            if (height[start] < height[end]) {
                start++;
            } else {
                end--;
            }
        }
        return max;
    }
    
    private int calcWater(int[] height, int left, int right) {
        return Math.min(height[left], height[right]) * (right - left);
    }
}