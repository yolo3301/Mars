/* The guess API is defined in the parent class GuessGame.
   @param num, your guess
   @return -1 if my number is lower, 1 if my number is higher, otherwise return 0
      int guess(int num); */

public class Solution extends GuessGame {
    public int guessNumber(int n) {
        int s = 1, e = n;
        while (s < e) {
            // use long to prevent int overflow
            long n1 = (long) s;
            long n2 = (long) e;
            long n3 = (n1 + n2) / 2;
            int m = (int) n3;
            int g = guess(m);
            if (g == 0) return m;
            else if (g < 0) {
                e = m - 1;
            } else {
                s = m + 1;
            }
        }

        return s;
    }
}
