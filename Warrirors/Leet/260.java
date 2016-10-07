public class Solution {
    public int[] singleNumber(int[] nums) {
        // first run
        int x = nums[0];
        for (int i = 1; i < nums.length; i++) {
            x ^= nums[i];
        }

        // check first bit that's 1
        int n = 0;
        while (((x >> n) & 1) != 1) {
            n++;
        }

        // second run
        int y = 0, z = 0;
        for (int i = 0; i < nums.length; i++) {
            if (((nums[i] >> n) & 1) != 1) {
                y ^= nums[i];
            } else {
                z ^= nums[i];
            }
        }

        return new int[] {y, z};
    }
}
