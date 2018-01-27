class Solution {
    public int maxChunksToSorted(int[] arr) {
        int[] expect = arr.clone();
        Arrays.sort(expect);
        Map<Integer, Queue<Integer>> index = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {
            if (!index.containsKey(expect[i]))
                index.put(expect[i], new LinkedList<>());

            index.get(expect[i]).add(i);
        }

        int nextStart = 0;
        int expectedSize = -1;
        Set<Integer> set = new HashSet<>();
        int ret = 0;

        for (int n : arr) {
            int x = index.get(n).remove();
            expectedSize = Math.max(expectedSize, x - nextStart + 1);
            set.add(x);

            if (set.size() == expectedSize) {
                ret++;
                nextStart = nextStart + expectedSize;
                set = new HashSet<>();
                expectedSize = -1;
            }
        }

        return ret;
    }
}