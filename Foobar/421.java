class Solution {
    public int findMaximumXOR(int[] nums) {
        int mask = 0, max = 0;
        for (int i = 31; i >= 0; i--) {
            mask |= (1 << i);
            Set<Integer> prefix = new HashSet<>();
            for (int n : nums) {
                prefix.add(n & mask);
            }

            int tmpMax = max | (1 << i);
            for (int p : prefix) {
                if (prefix.contains(p ^ tmpMax)) {
                    max = tmpMax;
                    break;
                }
            }
        }

        return max;
    }
}