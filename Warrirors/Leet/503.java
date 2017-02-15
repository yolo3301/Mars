public class Solution {
    public int[] nextGreaterElements(int[] nums) {
        if (nums.length == 0) return new int[0];
        int len = nums.length;
        int[] res = new int[len];
        Deque<Integer> s = new LinkedList<>();

        for (int i = len - 1; i >= 0; i--) {
            while (!s.isEmpty() && nums[Math.abs(s.peekFirst())] <= nums[i]) {
                s.removeFirst();
            }
            s.addFirst(-i);
        }

        for (int i = len - 1; i >= 0; i--) {
            while (!s.isEmpty() && s.peekLast() <= 0 && Math.abs(s.peekLast()) >= i) {
                s.removeLast();
            }
            while (!s.isEmpty() && nums[Math.abs(s.peekFirst())] <= nums[i]) {
                s.removeFirst();
            }

            if (s.isEmpty()) res[i] = -1;
            else res[i] = nums[Math.abs(s.peekFirst())];

            s.addFirst(i);
        }

        return res;
    }
}