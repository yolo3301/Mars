/* The read4 API is defined in the parent class Reader4.
      int read4(char[] buf); */

public class Solution extends Reader4 {

    private char[] local = new char[4];
    private int localIndex = 4;
    private int localSize = 0;

    /**
     * @param buf Destination buffer
     * @param n   Maximum number of characters to read
     * @return    The number of characters read
     */
    public int read(char[] buf, int n) {
        if (n == 0) return 0;

        int cnt = 0;
        while (localIndex < localSize && cnt < n) {
            buf[cnt++] = local[localIndex++];
        }

        while (cnt < n) {
            localSize = read4(local);
            if (localSize == 0) break;
            localIndex = 0;
            while (localIndex < localSize && cnt < n) {
                buf[cnt++] = local[localIndex++];
            }
        }

        return cnt;
    }
}