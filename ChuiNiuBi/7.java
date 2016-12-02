/*
reverse integer
*/

public class Solution {
    public int reverse(int x) {
        int sign = 1;
        if (x < 0) {
            sign = -1;
            x = -x;
        }
        
        if (x / 10 == 0)
            return sign * x;
            
        int res = 0;
        while (x != 0) {
            int tmp = res;
            res = x % 10 + res * 10;
            if (res / 10 != tmp)
                return 0;
            x /= 10;
        }
        
        return sign * res;
    }
}