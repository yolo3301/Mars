public class Solution {
    public int[] nextGreaterElement(int[] findNums, int[] nums) {
        Map<Integer, Integer> next = new HashMap<>();
        Stack<Integer> s = new Stack<>();
        for (int i = nums.length - 1; i >= 0; i--) {
            while (!s.empty() && s.peek() <= nums[i]) {
                s.pop();
            }

            if (s.empty()) {
                next.put(nums[i], -1);
            } else {
                next.put(nums[i], s.peek());
            }
            
            s.push(nums[i]);
        }

        int[] res = new int[findNums.length];
        for (int i = 0; i < res.length; i++) {
            res[i] = next.get(findNums[i]);
        }

        return res;
    }
}