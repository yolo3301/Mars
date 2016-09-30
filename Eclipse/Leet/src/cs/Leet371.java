package cs;

public class Leet371 {
    public int getSum(int a, int b) {
    	// a ^ b to do ADD without carries
    	// a & b << 1 to calculate carries
        return b == 0 ? a : getSum(a ^ b, (a & b) << 1);
    }
}
