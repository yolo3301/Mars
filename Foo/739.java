class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int len = temperatures.length;
        int[] ret = new int[len];

        // Saves index
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < len; i++) {
            while (!stack.empty() && temperatures[stack.peek()] < temperatures[i]) {
                int prev = stack.pop();
                ret[prev] = i - prev;
            }
            stack.push(i);
        }

        return ret;
    }
}