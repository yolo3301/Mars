public class Solution {
    public int minTransfers(int[][] transactions) {
        Map<Integer, Integer> balance = new HashMap<>();
        for (int[] t : transactions) {
            balance.put(t[0], balance.getOrDefault(t[0], 0)-t[2]);
            balance.put(t[1], balance.getOrDefault(t[1], 0)+t[2]);
        }
        // cal balance and only keep non-zero ones
        List<Long> debt = new ArrayList<>();
        for (int k : balance.keySet()) {
            if (balance.get(k) != 0) debt.add((long)balance.get(k));
        }
        
        return dfs(0, 0, debt);
    }

    private int dfs(int index, int cnt, List<Long> debt) {
        while (index < debt.size() && debt.get(index) == 0) index++;
        int res = Integer.MAX_VALUE;
        long prev = 0;
        for (int i = index+1; i < debt.size(); i++) {
            if (debt.get(i) != prev && debt.get(i) * debt.get(index) < 0) {
                debt.set(i, debt.get(i) + debt.get(index));
                res = Math.min(res, dfs(index+1, cnt+1, debt));
                debt.set(i, debt.get(i) - debt.get(index));
                prev = debt.get(i);
            }
        }

        return (res < Integer.MAX_VALUE ? res : cnt);
    }
}