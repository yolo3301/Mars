public class Solution {
    public String rearrangeString(String s, int k) {
        if (k == 0) return s;
        
        int[] cnt = new int[26];
        int[] valid = new int[26]; // record next valid position
        for (int i = 0; i < s.length(); i++) {
            cnt[s.charAt(i) - 'a']++;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            int next = getNext(cnt, valid, i);
            if (next == -1) return "";
            cnt[next]--;
            valid[next] = i + k; // update the next valid position, has to be at least i+k
            sb.append((char)('a' + next));
        }

        return sb.toString();
    }

    private int getNext(int[] cnt, int[] valid, int index) {
        int cand = -1, maxCnt = 0;
        for (int i = 0; i < 26; i++) {
            // The letter with more appearance should be picked first
            // Also the position should be greater than the next valid position
            if (cnt[i] > 0 && cnt[i] > maxCnt && index >= valid[i]) {
                cand = i;
                maxCnt = cnt[i];
            }
        }

        return cand;
    }
}