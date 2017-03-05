public class Solution {
    public int hIndex(int[] citations) {
        if (citations.length == 0) return 0;
        Arrays.sort(citations);

        for (int i = 0; i < citations.length; i++) {
            if (citations.length - i <= citations[i]) return citations.length - i;
        }

        return 0;
    }
}

public class Solution {
    public int hIndex(int[] citations) {
        if (citations.length == 0) return 0;

        // cnt works as a reversed index of # of citations
        // index is the # of citations,. value is the # of papers with that many citations
        // by accumulating the total papers and compare with the # of citations
        // the assumption here is the highest H index is # of of total papers
        int[] cnt = new int[citations.length+1];
        for (int c : citations) {
            if (c >= citations.length) {
                cnt[citations.length]++;
            } else {
                cnt[c]++;
            }
        }

        int total = 0;

        for (int i = citations.length; i >= 0; i--) {
            total += cnt[i];
            if (total >= i) return i;
        }

        return 0;
    }
}