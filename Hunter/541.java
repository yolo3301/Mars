public class Solution {
    public String reverseStr(String s, int k) {
        char[] chs = s.toCharArray();
        int i = 0;
        boolean flag = true;
        while (i < chs.length) {
            int j = Math.min(i+k, chs.length);
            if (flag) {
                for (int z = 0; z < (j - i)/2; z++) {
                    swap(chs, i+z, j-z-1);
                }
                flag = false;
            } else {
                flag = true;
            }
            i = j;
        }
        
        return new String(chs);
    }

    private void swap(char[] chs, int i, int j) {
        char tmp = chs[i];
        chs[i] = chs[j];
        chs[j] = tmp;
    }
}