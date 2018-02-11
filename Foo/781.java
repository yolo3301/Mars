class Solution {
    public int numRabbits(int[] answers) {
        Map<Integer, Integer> map = new HashMap<>();
        int ret = 0;
        for (int a : answers) {
            if (a != 0)
                map.put(a, map.getOrDefault(a, 0) + 1);
            else ret++;
        }
        for (int s : map.keySet()) {
            int v = map.get(s);
            ret += (v / (s + 1)) * (s + 1); // group
            if (v % (s + 1) != 0) ret += (s + 1);
        }

        return ret;
    }
}