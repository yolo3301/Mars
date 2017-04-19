public class Solution {
    public int getMaxRepetitions(String s1, int n1, String s2, int n2) {
        if (!validate(s1, s2)) return 0;

        List<Integer> cntList = new ArrayList<>();
        List<String> remainList = new ArrayList<>();
        cntList.add(0);
        remainList.add("");
        int cnt = 0, k = -1;
        String s = s1;
        StringBuilder remainBuilder;

        for (int i = 0; i < n1; i++) {
            remainBuilder = new StringBuilder();
            cnt += getRemain(s, s2, remainBuilder);
            String remain = remainBuilder.toString();
            if ((k = remainList.indexOf(remain)) != -1) break;
            cntList.add(cnt);
            remainList.add(remain);
            s = remain + s1;
        }

        if (k == -1) return cnt / n2;
        int cntInLoop = cnt - cntList.get(k);
        int loopSize = remainList.size() - k;
        cnt = cntList.get(k);
        n1 -= k;
        cnt += (n1 / loopSize) * cntInLoop;
        n1 %= loopSize;
        cnt += cntList.get(k+n1) - cntList.get(k); // why? think about the remaining
        return cnt / n2;
    }

    private int getRemain(String s1, String s2, StringBuilder sb) {
        int cnt = 0, last = 0;
        int i = 0, j = 0;
        while (i < s1.length()) {
            if (s1.charAt(i) != s2.charAt(j)) i++;
            else {
                i++;
                j++;
                if (j == s2.length()) {
                    cnt++;
                    j = 0;
                    last = i;
                }
            }
        }

        sb.append(s1.substring(last));
        return cnt;
    }

    private boolean validate(String s1, String s2) {
        int[] cnt = new int[26];
        for (char ch : s1.toCharArray())
            cnt[ch - 'a']++;

        for (char ch : s2.toCharArray())
            if (cnt[ch - 'a'] == 0) return false;

        return true;
    }
}