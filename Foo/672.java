class Solution {
    public int flipLights(int n, int m) {
        if (m == 0 || n == 0) return 1;
        if (n == 1) return 2;
        if (n == 2) return m == 1? 3:4;
        if (m == 1) return 4;
        return m == 2? 7:8; // 1+2=3, 1+3=2, 2+3=1, so => 1,2,3,4,1+4,2+4,3+4,all_off
    }
}