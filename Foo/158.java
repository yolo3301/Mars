/* The read4 API is defined in the parent class Reader4.
      int read4(char[] buf); */

public class Solution extends Reader4 {
    private int lastStartIndex = 4;
    private char[] last;
    private int lastSize = 0;

    /**
     * @param buf Destination buffer
     * @param n   Maximum number of characters to read
     * @return    The number of characters read
     */
    public int read(char[] buf, int n) {
        int j = 0;
        for ( ; lastStartIndex < lastSize && j < n; lastStartIndex++) {
            buf[j++] = last[lastStartIndex];
        }

        while (n - j > 0) {
            char[] temp = new char[4];
            int curr = read4(temp);
            
            last = temp;
            lastSize = curr;
            if (curr <= 0) break;

            for (lastStartIndex = 0; lastStartIndex < curr && j < n; lastStartIndex++) {
                buf[j++] = temp[lastStartIndex];
            }
        }

        return j;
    }
}