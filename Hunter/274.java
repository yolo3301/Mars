public class Solution {
    public int hIndex(int[] citations) {
        if (citations.length == 0) return 0;
        int[] cnt = new int[citations.length+1];

        for (int c : citations) {
            if (c >= citations.length) {
                cnt[citations.length]++;
            } else {
                cnt[c]++;
            }
        }

        int sum = 0;
        for (int i = cnt.length-1; i >= 0; i--) {
            sum += cnt[i];
            if (sum >= i) return i;
        }

        return 0;
    }
}