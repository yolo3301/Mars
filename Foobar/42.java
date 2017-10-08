class Solution {
    public int trap(int[] height) {
        if (height.length == 0) return 0;
        
        int highest = height[0];
        int[] limit = new int[height.length];
        for (int i = 1; i < height.length; i++) {
            if (height[i] <= highest) {
                limit[i] = highest - height[i];
            } else {
                highest = height[i];
            }
        }

        int res = 0;
        highest = height[height.length-1];
        for (int i = height.length - 2; i >= 0; i--) {
            if (height[i] <= highest) {
                limit[i] = Math.min(limit[i], highest - height[i]);
            } else {
                limit[i] = 0;
                highest = height[i];
            }
            res += limit[i];
        }

        return res;
    }
}
