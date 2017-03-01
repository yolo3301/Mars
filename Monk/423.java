public class Solution {
    public String originalDigits(String s) {
        int[] cnt = new int[26];
        for (char ch : s.toCharArray()) {
            cnt[ch - 'a']++;
        }

        int[] num = new int[10];
        if (cnt['z' - 'a'] > 0) {
            num[0] = cnt['z' - 'a'];
            cnt['e' - 'a'] -= num[0];
            cnt['r' - 'a'] -= num[0];
            cnt['o' - 'a'] -= num[0];
        }

        if (cnt['w' - 'a'] > 0) {
            num[2] = cnt['w' - 'a'];
            cnt['t' - 'a'] -= num[2];
            cnt['o' - 'a'] -= num[2];
        }

        if (cnt['u' - 'a'] > 0) {
            num[4] = cnt['u' - 'a'];
            cnt['f' - 'a'] -= num[4];
            cnt['o' - 'a'] -= num[4];
            cnt['r' - 'a'] -= num[4];
        }

        if (cnt['x' - 'a'] > 0) {
            num[6] = cnt['x' - 'a'];
            cnt['s' - 'a'] -= num[6];
            cnt['i' - 'a'] -= num[6];
        }

        if (cnt['g' - 'a'] > 0) {
            num[8] = cnt['g' - 'a'];
            cnt['e' - 'a'] -= num[8];
            cnt['i' - 'a'] -= num[8];
            cnt['h' - 'a'] -= num[8];
            cnt['t' - 'a'] -= num[8];
        }

        if (cnt['o' - 'a'] > 0) {
            num[1] = cnt['o' - 'a'];
            cnt['n' - 'a'] -= num[1];
            cnt['e' - 'a'] -= num[1];
        }

        if (cnt['t' - 'a'] > 0) {
            num[3] = cnt['t' - 'a'];
            cnt['h' - 'a'] -= num[3];
            cnt['r' - 'a'] -= num[3];
            cnt['e' - 'a'] -= num[3];
            cnt['e' - 'a'] -= num[3];
        }

        if (cnt['f' - 'a'] > 0) {
            num[5] = cnt['f' - 'a'];
            cnt['i' - 'a'] -= num[5];
            cnt['v' - 'a'] -= num[5];
            cnt['e' - 'a'] -= num[5];
        }

        if (cnt['s' - 'a'] > 0) {
            num[7] = cnt['s' - 'a'];
            cnt['e' - 'a'] -= num[7];
            cnt['e' - 'a'] -= num[7];
            cnt['v' - 'a'] -= num[7];
            cnt['n' - 'a'] -= num[7];
        }

        if (cnt['i' - 'a'] > 0) {
            num[9] = cnt['i' - 'a'];
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 10; i++) {
            if (num[i] > 0) {
                for (int j = 0; j < num[i]; j++) {
                    sb.append(i);
                }
            }
        }

        return sb.toString();
    }
}