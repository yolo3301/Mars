public class Solution {
    public int findLHS(int[] nums) {
        Map<Integer, Integer> cnt = new HashMap<>();
        for (int i : nums) {
            cnt.put(i, cnt.getOrDefault(i, 0)+1);
        }

        int res = 0;
        for (int k : cnt.keySet()) {
            if (cnt.containsKey(k-1)) {
                res = Math.max(res, cnt.get(k)+cnt.get(k-1));
            }
            if (cnt.containsKey(k+1)) {
                res = Math.max(res, cnt.get(k) + cnt.get(k+1));
            }
        }

        return res;
    }
}