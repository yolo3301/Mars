public class Solution {
    public int findMaximumXOR(int[] nums) {
        int max = 0, mask = 0;
        // bit by bit
        for (int i = 31; i >= 0; i--) {
            // get most significant bits of nums
            mask = mask | (1 << i);
            Set<Integer> set = new HashSet<>();
            for (int num : nums) {
                set.add(num & mask);
            }

            // get most significant bits of max + current bit
            int tmp = max | (1 << i);
            for (int prefix : set) {
                // ^ operation makes sure that there is 2 num that all the MSB
                // that if a bit in max is 1, their corresponding bits are different
                if (set.contains(tmp ^ prefix)) {
                    max = tmp;
                    break;
                }
            }
        }
        return max;
    }
}
