class Solution {
    public int singleNumber(int[] nums) {
        int[] bits = new int[32];
        for (int n : nums) {
            for (int i = 0; i < 32; i++) {
                bits[i] += ((n >> i) & 1);
            }
        }

        int ret = 0;
        for (int i = 0; i < 32; i++) {
            ret += ((bits[i] % 3) << i);
        }

        return ret;
    }
}
