public class Solution {
    public int scheduleCourse(int[][] courses) {
        if (courses.length == 0) return 0;
        Arrays.sort(courses, (a, b) -> a[1] - b[1]);
        PriorityQueue<Integer> cost = new PriorityQueue<>((a, b) -> b-a);

        int time = 0; // total time needed
        // c[1] means the deadline for each course
        for (int[] c : courses) {
            time += c[0];
            cost.add(c[0]);
            // If c[1] is less than total time needed, we remove most costly course
            while (time > c[1] && !cost.isEmpty()) time -= cost.remove();
        }

        return cost.size();
    }
}