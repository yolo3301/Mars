class Solution {
    public int maxChunksToSorted(int[] arr) {
        int nextStart = 0;
        int expectedSize = -1;
        int ret = 0;

        Set<Integer> set = new HashSet<>();

        // If say [10, 0], then we know we must have a set size 11 to complete the sort
        for (int n : arr) {
            set.add(n);
            expectedSize = Math.max(expectedSize, n - nextStart + 1);

            if (set.contains(nextStart) && set.size() == expectedSize) {
                ret++;
                nextStart = nextStart + expectedSize;
                expectedSize = -1;
                set = new HashSet<>();
            }
        }

        return ret;
    }
}