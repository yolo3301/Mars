class Solution {
    public int minTransfers(int[][] transactions) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int[] t : transactions) {
            map.put(t[0], map.getOrDefault(t[0], 0) - t[2]);
            map.put(t[1], map.getOrDefault(t[1], 0) + t[2]);
        }

        List<Integer> p = new ArrayList<>();
        for (int k : map.keySet()) {
            if (map.get(k) != 0) p.add(map.get(k));
        }

        int matches = removeExactMatches(p);
        return matches + bt(0, p);
    }

    // Optimize
    private int removeExactMatches(List<Integer> p) {
        Collections.sort(p);
        int l = 0, r = p.size()-1;
        int matches = 0;
        while (l < r) {
            if (p.get(l) + p.get(r) == 0) {
                p.remove(l);
                p.remove(r-1);
                r -= 2;
                matches++;
            } else if (p.get(l) + p.get(r) > 0) {
                r--;
            } else {
                l++;
            }
        }

        return matches;
    }

    private int bt(int index, List<Integer> p) {
        while (index < p.size() && p.get(index) == 0) index++;
        if (index == p.size()) return 0;
        int ret = Integer.MAX_VALUE;
        for (int i = index+1; i < p.size(); i++) {
            if ((long) p.get(i) * p.get(index) < 0) {
                p.set(i, p.get(i) + p.get(index));
                int next = bt(index+1, p);

                ret = Math.min(ret, next == Integer.MAX_VALUE ? next : next + 1);
                p.set(i, p.get(i) - p.get(index));
            }
        }
        return ret;
    }
}