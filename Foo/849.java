class Solution {
    public int maxDistToClosest(int[] seats) {
        int[] next = new int[seats.length];
        for (int i = seats.length-1; i >= 0; i--) {
            if (seats[i] == 1) next[i] = i;
            else if (i == seats.length-1) next[i] = 2 * seats.length;
            else next[i] = next[i+1];
        }

        int last = -seats.length;
        int maxDist = 0;
        for (int i = 0; i < seats.length; i++) {
            if (seats[i] == 1) last = i;
            else {
                int dist = Math.min(i-last, next[i]-i);
                if (dist > maxDist) {
                    maxDist = dist;
                }
            }
        }

        return maxDist;
    }
}