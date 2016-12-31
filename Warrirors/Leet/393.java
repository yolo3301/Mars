public class Solution {

    int b1 = 1 << 7;
    int b2 = 1 << 6;
    int b3 = 1 << 5;
    int b4 = 1 << 4;
    int b5 = 1 << 3;
    int b2t = b1 + b2;
    int b3t = b2t + b3;
    int b4t = b3t + b4;
    int b5t = b4t + b5;

    public boolean validUtf8(int[] data) {
        int i = 0;
        while (i < data.length) {
            int nb = howManyBytes(data[i++]);
            if (nb == -1) return false;
            if (i + nb - 1 > data.length) return false;
            for (int j = 0; j < nb - 1; j++) {
                if (!validByte(data[i++]))
                    return false;
            }
        }

        return true;
    }

    private int howManyBytes(int x) {
        if ((x & b1) == 0) return 1;
        if ((x & b3t) == b2t) return 2;
        if ((x & b4t) == b3t) return 3;
        if ((x & b5t) == b4t) return 4;
        return -1;
    }

    private boolean validByte(int x) {
        return (x & b2t) == b1;
    }
}
