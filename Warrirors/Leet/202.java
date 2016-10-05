public class Solution {
    public boolean isHappy(int n) {
        if (n <= 0) return false;
        if (n == 1) return true;

        Set<Integer> set = new HashSet<>();
        int x = n;

        while (true) {
            set.add(x);
            x = getNext(x);
            if (x == 1) return true;
            if (set.contains(x)) return false;
        }
    }

    private int getNext(int n) {
        int res = 0;
        while (n != 0) {
            int t = n % 10;
            res += t * t;
            n /= 10;
        }

        return res;
    }
}
