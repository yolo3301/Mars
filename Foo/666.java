class Solution {
    public int pathSum(int[] nums) {
        Map<Integer, Integer> sums = new HashMap<>();
        Set<Integer> leaves = new HashSet<>();
        for (int i : nums) {
            int v = i % 10;
            int p = getParent(i / 10);
            sums.put(i/10, v + sums.getOrDefault(p, 0));
            leaves.add(i/10);
            leaves.remove(p);
        }

        int res = 0;
        for (int leaf : leaves) {
            res += sums.get(leaf);
        }

        return res;
    }

    private int getParent(int x) {
        int level = x / 10;
        int index = x % 10;

        return 10 * (level-1) + ((index-1) / 2)+1;
    }
}