class Solution {
    public int rotatedDigits(int N) {
        int cnt = 0;
        for (int i = 1; i <= N; i++) {
            int cur = i;
            boolean chg = false, work = true;
            while (cur > 0) {
                int z = cur % 10;
                if (z == 6 || z == 9 || z == 2 || z == 5)
                    chg = true;
                if (z == 3 || z == 4 || z == 7) {
                    work = false;
                    break;
                }
                cur /= 10;
            }

            if (chg && work) cnt++;
        }
        return cnt;
    }
}