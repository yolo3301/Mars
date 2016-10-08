public class Solution {

    private int[] origin;
    private Random random;

    public Solution(int[] nums) {
        this.origin = nums;
        this.random = new Random();
    }

    /** Resets the array to its original configuration and return it. */
    public int[] reset() {
        return origin;
    }

    /** Returns a random shuffling of the array. */
    public int[] shuffle() {
        int[] res = Arrays.copyOf(origin, origin.length);
        for (int i = origin.length - 1; i >= 0; i--) {
            int rand = random.nextInt(i + 1);
            int tmp = res[rand];
            res[rand] = res[i];
            res[i] = tmp;
        }

        return res;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int[] param_1 = obj.reset();
 * int[] param_2 = obj.shuffle();
 */
