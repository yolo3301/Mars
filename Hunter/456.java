public class Solution {
    public boolean find132pattern(int[] nums) {
        if (nums.length < 3) return false;
        Stack<Integer> s = new Stack<>();
        int s3 = Integer.MIN_VALUE;
        for (int i = nums.length - 1; i >= 0; i--) {
            if (nums[i] < s3) return true;

            while (!s.empty() && s.peek() < nums[i]) {
                s3 = s.pop();
            }

            s.push(nums[i]);
        }

        return false;
    }
}