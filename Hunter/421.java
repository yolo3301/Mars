public class Solution {
    public int findMaximumXOR(int[] nums) {
        int max = 0, mask = 0;
        for (int i = 31; i >= 0; i--) {
            mask = mask | (1 << i);
            Set<Integer> set = new HashSet<>();
            for (int j : nums) {
                set.add(j & mask);
            }

            int tmpMax = max | (1 << i);
            for (int prefix : set) {
                if (set.contains(tmpMax ^ prefix)) {
                    max = tmpMax;
                    break;
                }
            }
        }

        return max;
    }
}