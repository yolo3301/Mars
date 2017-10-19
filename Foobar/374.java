/* The guess API is defined in the parent class GuessGame.
   @param num, your guess
   @return -1 if my number is lower, 1 if my number is higher, otherwise return 0
      int guess(int num); */

public class Solution extends GuessGame {
    public int guessNumber(int n) {
        int s = 1, e = n;
        while (true) {
            int m = s + (e - s) / 2;
            int cur = guess(m);
            if (cur == 0) return m;
            else if (cur > 0) s = m+1;
            else e = m-1;           
        }
    }
}
