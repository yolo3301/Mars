public class Solution {
    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, new Comparator<int[]>() {
            public int compare(int[] v1, int v2[]) {
                if (v1[0] == v2[0]) return v1[1] - v2[1];
                return v2[0] - v1[0];
            }
        });

        List<int[]> res = new ArrayList<>();
        for (int i = 0; i < people.length; i++) {
            res.add(people[i][1] < res.size() ? people[i][1] : res.size(), people[i]);
        }

        return res.toArray(new int[0][0]);
    }
}