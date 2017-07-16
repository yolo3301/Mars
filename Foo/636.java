public class Solution {
    public int[] exclusiveTime(int n, List<String> logs) {
        int[] res = new int[n];

        int lastTime = -1;
        boolean isLastStart = false;

        Stack<Integer> stack = new Stack<>();
        for (String log : logs) {
            String[] p = log.split(":");
            int funcId = Integer.valueOf(p[0]);
            boolean isStart = p[1].equals("start");
            int time = Integer.valueOf(p[2]);
            
            if (stack.empty()) {
                lastTime = time;
                isLastStart = isStart;
                stack.push(funcId);
            } else {
                int timeDiff = time - lastTime;
                if (!isStart && isLastStart) timeDiff++;
                if (isStart && !isLastStart) timeDiff--;
                
                lastTime = time;
                isLastStart = isStart;

                res[stack.peek()] += timeDiff;
                if (isStart) stack.push(funcId);
                else stack.pop();
            }
        }

        return res;
    }
}