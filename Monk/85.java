public class Solution {
    public int maximalRectangle(char[][] matrix) {
        int m = matrix.length;
        if (m == 0) return 0;
        int n = matrix[0].length;
        if (n == 0) return 0;

        int[][] ones = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0) ones[i][j] = matrix[i][j] - '0';
                else {
                    if (matrix[i][j] == '0') ones[i][j] = 0;
                    else ones[i][j] = ones[i-1][j] + 1;
                }
            }
        }

        int res = 0;
        for (int i = 0; i < m; i++) {
            res = Math.max(res, maxHistogram(ones[i]));
        }

        return res;
    }

    private int maxHistogram(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        int res = 0;
        for (int i = 0; i <= heights.length; i++) {
            int h = (i == heights.length) ? 0 : heights[i];
            if (stack.empty() || h >= heights[stack.peek()]) {
                stack.push(i);
            } else {
                while (!stack.empty() && heights[stack.peek()] > h) {
                    int prev = stack.pop();
                    while (!stack.empty() && heights[stack.peek()] == heights[prev]) {
                        stack.pop();
                    }

                    if (stack.empty()) {
                        res = Math.max(res, heights[prev] * i);
                    } else {
                        res = Math.max(res, heights[prev] * (i - stack.peek() - 1));
                    }
                }
                stack.push(i);
            }
        }

        return res;
    }
}