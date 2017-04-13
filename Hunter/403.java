public class Solution {
    public boolean canCross(int[] stones) {
        if (stones.length <= 1) return true;
        Map<Integer, Set<Integer>> nextJump = new HashMap<>();
        nextJump.put(0, new HashSet<>());
        nextJump.get(0).add(1);

        for (int i : stones) {
            if (!nextJump.containsKey(i)) continue;
            for (int j : nextJump.get(i)) {
                if (!nextJump.containsKey(i+j)) nextJump.put(i+j, new HashSet<>());
                if (j - 1 > 0) nextJump.get(i+j).add(j-1);
                nextJump.get(i+j).add(j);
                nextJump.get(i+j).add(j+1);
            }
        }

        return nextJump.containsKey(stones[stones.length-1]);
    }
}