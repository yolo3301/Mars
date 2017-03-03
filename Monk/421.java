public class Solution {
    public int findMaximumXOR(int[] nums) {
        int max = 0, mask = 0;
        // Only need to make sure each MSB, there are at least 2 bits that are different
        for (int i = 31; i >= 0; i--) {
            mask = mask | (1 << i);

            Set<Integer> set = new HashSet<>();
            for (int n : nums) {
                set.add(n & mask);
            }

            int tmp = max | (1 << i);
            for (int prefix : set) {
                // In tmp, the new MSB will always be 1 at the beginning.
                // By using ^, it makes sure 2 things:
                // 1. there are at least 2 nums that are different at this bit
                // 2. It doesn't change any previous MSBs
                if (set.contains(tmp ^ prefix)) {
                    max = tmp;
                    break;
                }
            }
        }

        return max;
    }
}