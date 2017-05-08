public class Solution {
    public int getMaxRepetitions(String s1, int n1, String s2, int n2) {
        if (!isValid(s1, s2)) return 0;

        List<String> remainList = new ArrayList<>();
        List<Integer> cntList = new ArrayList<>();
        cntList.add(0);
        remainList.add("");
        StringBuilder remainBuilder = null;
        int cnt = 0, loopStart = -1;
        String s = s1;

        for (int i = 0; i < n1; i++) {
            remainBuilder = new StringBuilder();
            cnt += getRemain(s, s2, remainBuilder);
            String remain = remainBuilder.toString();

            if ((loopStart = remainList.indexOf(remain)) != -1) break;

            cntList.add(cnt);
            remainList.add(remain);
            s = remain + s1;
        }

        if (loopStart == -1) return cnt / n2;
        int loopCnt = cnt - cntList.get(loopStart);
        int loopSize = remainList.size() - loopStart;
        cnt = cntList.get(loopStart);
        n1 -= loopStart;
        cnt += (n1 / loopSize) * loopCnt;
        n1 %= loopSize;
        cnt += cntList.get(loopStart+n1) - cntList.get(loopStart);

        return cnt;
    }

    private int getRemain(String s1, String s2, StringBuilder sb) {
        int cnt = 0;
        int j = 0, e = 0;
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) == s2.charAt(j)) {
                j++;
                if (j == s2.length()) {
                    cnt++;
                    e = i+1;
                    j = 0;
                }
            }
        }

        sb.append(s1.substring(e));
        return cnt;
    }

    private boolean isValid(String s1, String s2) {
        int[] cnt = new int[26];
        for (char ch : s1.toCharArray()) {
            cnt[ch - 'a']++;
        }

        for (char ch : s2.toCharArray()) {
            if (cnt[ch - 'a'] == 0) return false;
        }

        return true;
    }
}