/* The read4 API is defined in the parent class Reader4.
      int read4(char[] buf); */

public class Solution extends Reader4 {
    /**
     * @param buf Destination buffer
     * @param n   Maximum number of characters to read
     * @return    The number of characters read
     */
    public int read(char[] buf, int n) {
        int cnt = 0;
        while (cnt < n) {
            char[] tmp = new char[4];
            int local = read4(tmp);
            if (local == 0) break;
            for (int i = 0; i < local && cnt < n; i++)
                buf[cnt++] = tmp[i];
        }

        return cnt;
    }
}