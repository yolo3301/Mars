package cs;

public class Leet400 {
	public int findNthDigit(int n) {
        long start = 1, upper = 9, digit = 1, last = 0;
        while (n > upper) {
        	System.out.println("start:" + start + " upper:" + upper + " digits:" + digit + " last:" + last);
            start *= 10;
            digit++;
            last = upper;
            upper += 9 * digit * start;
        }
        
        System.out.println("start:" + start + " upper:" + upper + " digits:" + digit + " last:" + last);

        long x = (n - last - 1) / digit;
        System.out.println("x:" + x);
        
        long y = (n - last - 1) % digit;
        System.out.println("y:" + y);

        long target = start + x;
        System.out.println("target:" + target);
        
        long z = start;
        for (int i = 0; i < y; i++) {
            z /= 10;
        }

        return (int) (target / z) % 10;
    }
}
