public class Solution {
    public int leastInterval(char[] tasks, int n) {
        if (tasks.length == 0) return 0;

        int[] next = new int[26];
        int[] cnt = new int[26];
        for (char t : tasks) {
            cnt[t - 'A']++;
        }

        int res = 0, total = 0;
        while (total < tasks.length) {
            int m = findNext(res, cnt, next);
            // System.out.println(m);
            if (m != -1) {
                cnt[m]--;
                total++;
                next[m] = res + n + 1;
            }
            res++;
        }

        return res;
    }

    private int findNext(int currIndex, int[] cnt, int[] next) {
        int cand = -1, maxCnt = 0;
        for (int i = 0; i < 26; i++) {
            if (cnt[i] > maxCnt && next[i] <= currIndex) {
                cand = i;
                maxCnt = cnt[i];
            }
        }
        return cand;
    }
}