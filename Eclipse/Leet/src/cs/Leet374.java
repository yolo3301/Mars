package cs;

public class Leet374 {
    public int guessNumber(int n) {
        int s = 1, e = n;
        while (s < e) {
            int m = (s + e) / 2;
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
    
    public int guess(int n) {
    	return 1702766719 - n;
    }
}
