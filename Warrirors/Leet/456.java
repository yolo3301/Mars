public class Solution {
    public boolean find132pattern(int[] nums) {
        if (nums.length < 3) return false;
        // s3 is the third number
        int s3 = Integer.MIN_VALUE;
        Stack<Integer> st = new Stack<>();
        for (int i = nums.length - 1; i >= 0; i--) {
            if (nums[i] < s3) return true;

            // In this case
            // s3 will be the last one popped, which is the max less than nums[i]
            // and nums[i] will become the candidate for s2
            while (!st.empty() && st.peek() < nums[i]) {
                s3 = st.pop();
            }
            st.push(nums[i]);
        }
        return false;
    }
}
