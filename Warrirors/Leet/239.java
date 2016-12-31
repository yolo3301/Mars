public class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums.length == 0) return new int[0];
        int[] res = new int[nums.length - k + 1];
        Deque<Integer> deque = new LinkedList<>();

        for (int i = 0; i < k; i++) {
            while (!deque.isEmpty() && deque.peekLast() < nums[i]) {
                deque.removeLast();
            }
            deque.addLast(nums[i]);
        }

        for (int i = k, j = 0; i < nums.length; i++, j++) {
            res[j] = deque.peekFirst();
            int toRemove = nums[j];
            int toAdd = nums[i];
            if (deque.peekFirst() == toRemove) {
                deque.removeFirst();
            }

            while (!deque.isEmpty() && deque.peekLast() < toAdd) {
                deque.removeLast();
            }
            deque.addLast(toAdd);
        }

        res[res.length - 1] = deque.peekFirst();

        return res;
    }
}
