public class Solution {
    public int[] singleNumber(int[] nums) {
        int all = 0;
        for (int i : nums) {
            all ^= i;
        }

        int shift = 0;
        while (((all >> shift) & 1) != 1) {
            shift++;
        }

        int a = 0, b = 0;
        for (int i : nums) {
            if (((i >> shift) & 1) == 1) {
                a ^= i;
            } else {
                b ^= i;
            }
        }

        return new int[] {a, b};
    }
}