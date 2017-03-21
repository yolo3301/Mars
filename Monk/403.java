// Find my own way to do it!
public class Solution {
    public boolean canCross(int[] stones) {
        if (stones.length == 0) return true;
        Map<Integer, Set<Integer>> steps = new HashMap<>();
        for (int i = 0; i < stones.length; i++) {
            steps.put(stones[i], new HashSet<>());
        }
        steps.get(stones[0]).add(1);

        for (int i = 0; i < stones.length; i++) {
            if (steps.get(stones[i]).isEmpty()) continue;
            for (int j : steps.get(stones[i])) {
                if (steps.containsKey(stones[i] + j)) {
                    if (j - 1 > 0)
                        steps.get(stones[i] + j).add(j-1);
                    if (j > 0)
                        steps.get(stones[i] + j).add(j);
                    steps.get(stones[i] + j).add(j+1);
                }
            }
        }

        return !steps.get(stones[stones.length - 1]).isEmpty();
    }
}