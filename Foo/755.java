class Solution {
    public int[] pourWater(int[] heights, int V, int K) {
        for (int i = 0; i < V; i++) {
            int left = findPlace(heights, K, -1);
            if (left != -1) {
                heights[left]++;
                continue;
            }
            int right = findPlace(heights, K, 1);
            if (right != -1) {
                heights[right]++;
                continue;
            }
            heights[K]++;
        }
        return heights;
    }

    private int findPlace(int[] heights, int start, int dir) {
        int lowest = heights[start];
        int prev = lowest;
        int lowestIndex = -1;
        for (int i = start+dir; i >= 0 && i < heights.length; i += dir) {
            if (heights[i] < lowest) {
                lowest = heights[i];
                lowestIndex = i;
            }
            if (heights[i] > prev) break;
            prev = heights[i];
        }
        return lowestIndex;
    }
}