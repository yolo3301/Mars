public class Solution {
    public int maximalRectangle(char[][] matrix) {
        int m = matrix.length;
        if (m == 0) return 0;
        int n = matrix[0].length;
        if (n == 0) return 0;

        int res = 0;
        int[] heights = new int[n];
        for (int i = 0; i < n; i++) heights[i] = (matrix[0][i] == '1') ? 1 : 0;

        for (int i = 0; i < m; i++) {
            if (i > 0) {
                for (int j = 0; j < n; j++) {
                    if (matrix[i][j] == '0') heights[j] = 0;
                    else heights[j] += 1;
                }
            }

            res = Math.max(res, largestRectangleArea(heights));
        }

        return res;
    }

    public int largestRectangleArea(int[] heights) {
        if (heights.length == 0) return 0;
        int res = 0;
        Stack<Integer> s = new Stack<>();
        for (int i = 0; i <= heights.length; i++) {
            int h = (i == heights.length) ? 0 : heights[i];
            if (s.empty() || h >= heights[s.peek()]) {
                s.push(i);
            } else {
                while (!s.empty() && h < heights[s.peek()]) {
                    int prev = s.pop();
                    while (!s.empty() && heights[prev] == heights[s.peek()]) {
                        s.pop();
                    }

                    if (s.empty()) {
                        res = Math.max(res, heights[prev] * i);
                    } else {
                        res = Math.max(res, heights[prev] * (i - s.peek() - 1));
                    }
                }
                s.push(i);
            }
        }

        return res;
    }
}
