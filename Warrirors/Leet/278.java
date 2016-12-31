/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        int s = 1, e = n;
        while (s < e) {
            int m = s + (e - s) / 2;
            if (isBadVersion(m)) {
                e = m;
            } else {
                s = m + 1;
            }
        }

        if (s == e && isBadVersion(s)) return s;
        return -1;
    }
}
