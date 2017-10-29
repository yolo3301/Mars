class Solution {
    public boolean isOneBitCharacter(int[] bits) {
        int len = bits.length;
        if (len == 0 || bits[len-1] != 0) return false;
        if (len > 1 && bits[len-1] == 0 && bits[len-2] != 1) return true;

        return !check(bits, len-3);
    }

    private boolean check(int[] bits, int index) {
        if (index == -1) return true;
        if (index < -1) return false;
        if (bits[index] == 1) return index-1 >= 0 && bits[index-1] == 1 && check(bits, index-2);
        return check(bits, index-1)
            || (index-1 >= 0 && bits[index-1] == 1 && check(bits, index-2));
    }
}

class Solution {
    public boolean isOneBitCharacter(int[] bits) {
        int len = bits.length, i = 0;
        while (i < len-1) {
            if (bits[i] == 0) i++;
            else i += 2;
        }

        return (i == len-1);
    }
}
