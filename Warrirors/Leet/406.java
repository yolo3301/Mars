public class Solution {
    public int[][] reconstructQueue(int[][] people) {
        if (people.length == 0 || people[0].length == 0) return people;
        int n = people.length;

        // sort is from small to big
        // need to reverse here
        Arrays.sort(people, new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                if (a[0] == b[0]) return a[1] - b[1];
                return b[0] - a[0];
            }
        });

        // because the way we sort, it's always safe to move smaller number to the front
        List<int[]> res = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            res.add(people[i][1] <= res.size() ? people[i][1] : res.size(), people[i]);
        }

        return res.toArray(new int[0][0]);
    }
}
