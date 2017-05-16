/* The knows API is defined in the parent class Relation.
      boolean knows(int a, int b); */

public class Solution extends Relation {
    public int findCelebrity(int n) {
        if (n < 2) return -1;
        int cand = 0;
        for (int i = 1; i < n; i++) {
            if (knows(cand, i)) {
                cand = i;
            }
        }

        for (int i = 0; i < n; i++) {
            if (cand != i) {
                if (knows(cand, i)) return -1;
                if (!knows(i, cand)) return -1;
            }
        }

        return cand;
    }
}