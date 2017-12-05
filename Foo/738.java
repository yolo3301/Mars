class Solution {
    public int monotoneIncreasingDigits(int N) {
        char[] str = Integer.toString(N).toCharArray();
        int change = -1;
        for (int i = 0; i < str.length-1; i++) {
            if (str[i] > str[i+1]) {
                change = i;
                break;
            }
        }

        if (change == -1) return N;

        for (int i = change+1; i > 0; i--) {
            if (str[i-1] > str[i]) {
                str[i] = '9';
                str[i-1]--;
            } else {
                break;
            }
        }

        for (int i = change+2; i < str.length; i++) {
            str[i] = '9';
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length; i++) {
            if (sb.length() == 0 && str[i] <= '0') continue;
            sb.append(str[i]);
        }

        return Integer.valueOf(sb.toString());
    }
}

/*
100 -> 090 -> 099
101 -> 091 -> 099
312 -> 292 -> 299
332456 -> 332456 -> 299999
*/