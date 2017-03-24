public class Solution {
    public int getMaxRepetitions(String s1, int n1, String s2, int n2) {
        if (!preCheck(s1, s2)) return 0;
        String s = s1;
        int cnt = 0, k = -1;
        StringBuilder remainBuilder;
        List<Integer> cntList = new ArrayList<>();
        List<String> remainList = new ArrayList<>();
        cntList.add(0);
        remainList.add("");
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
        n1 -= k; // minus leading k 
        cnt += n1 / loopSize * cntInLoop;
        n1 %= loopSize;
        cnt += cntList.get(k+n1) - cntList.get(k);
        return cnt / n2;
    }

    private boolean preCheck(String s1, String s2) {
        char[] cnt = new char[26];
        for (char ch : s1.toCharArray()) cnt[ch - 'a']++;
        for (char ch : s2.toCharArray()) {
            if (cnt[ch - 'a'] == 0) return false;
        }
        return true;
    }

    private int getRemain(String s1, String s2, StringBuilder remainBuilder) {
        int cnt = 0, lastMatch = -1, j = 0;
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) == s2.charAt(j)) {
                if (++j == s2.length()) {
                    j = 0;
                    cnt++;
                    lastMatch = i;
                }
            }
        }
        remainBuilder.append(s1.substring(lastMatch+1));
        return cnt;
    }
}