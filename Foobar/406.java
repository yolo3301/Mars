class Solution {
    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, (a, b) -> {
            if (a[0] == b[0]) return a[1] - b[1];
            return b[0] - a[0];
        });

        List<int[]> ret = new ArrayList<>();
        for (int[] p : people) {
            ret.add(p[1] >= ret.size() ? ret.size() : p[1], p);
        }

        return ret.toArray(new int[0][0]);
    }
}

