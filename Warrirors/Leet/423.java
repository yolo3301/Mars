// reference https://discuss.leetcode.com/topic/63386/one-pass-o-n-java-solution-simple-and-clear/2
public class Solution {
    public String originalDigits(String s) {
        int[] count = new int[10];
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == 'z') count[0]++;
            if (c == 'w') count[2]++;
            if (c == 'x') count[6]++;
            if (c == 'g') count[8]++;
            if (c == 'u') count[4]++;
            if (c == 'f') count[5]++;  // 5 + 4
            if (c == 's') count[7]++;  // 6 + 7
            if (c == 'o') count[1]++;  // 0 + 1 + 2 + 4
            if (c == 'r') count[3]++;  // 0 + 3 + 4
            if (c == 'i') count[9]++;  // 5 + 6 + 8 + 9
        }

        count[5] -= count[4];
        count[7] -= count[6];
        count[1] -= count[0] + count[2] + count[4];
        count[3] -= count[0] + count[4];
        count[9] -= count[5] + count[6] + count[8];

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < count[i]; j++) {
                sb.append(i);
            }
        }

        return sb.toString();
    }
}
