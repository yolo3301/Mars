public class Solution {
    public boolean isPowerOfFour(int num) {
        // (num & (num - 1)) == 0 make sure there is only 1 '1'
        // A in bits is 1010, (num & (0xAAAAAAAA)) == 0 make sure no '1' on every 2 bits
        return num > 0 && (num & (num - 1)) == 0 && (num & (0xAAAAAAAA)) == 0;
    }
}
