// This works too~
public class Solution {
    public int largestRectangleArea(int[] heights) {
        if (heights.length == 0) return 0;

        int res = 0;
        int[] memo = new int[heights.length];

        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < heights.length; i++) {
            while (!stack.empty() && heights[stack.peek()] >= heights[i]) {
                stack.pop();
            }

            if (stack.empty()) {
                memo[i] = heights[i] * (i + 1);
            } else {
                memo[i] = heights[i] * (i - stack.peek());
            }

            stack.push(i);
        }

        stack = new Stack<>();
        for (int i = heights.length - 1; i >= 0; i--) {
            while (!stack.empty() && heights[stack.peek()] >= heights[i]) {
                stack.pop();
            }

            if (stack.empty()) {
                res = Math.max(res, memo[i] + heights[i] * (heights.length - 1 - i));
            } else {
                res = Math.max(res, memo[i] + heights[i] * (stack.peek() - 1 - i));
            }
        }

        return res;
    }
}

// Save some space
public class Solution {
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
