package cs;

public class Leet367 {
    public boolean isPerfectSquare(int num) {
        if (num == 1) return true;
        long s = 1, e = num / 2;
        while (s <= e) {
            long m = s + (e - s) / 2;
            long curr = m * m;
            if (curr == num) return true;
            else if (curr > num || curr <= 0) {
                e = m - 1;
            } else {
            	s = m + 1;
            }
        }
        return false;
    }
}
