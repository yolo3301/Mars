// no space
public class Solution {
    public int hIndex(int[] citations) {
        if (citations.length == 0) return 0;
        Arrays.sort(citations);
        for (int i = 0; i < citations.length; i++) {
            if (citations.length - i <= citations[i])
                return citations.length - i;
        }

        return 0;
    }
}

// O(n)
public class Solution {
    public int hIndex(int[] citations) {
        if (citations.length == 0) return 0;
        int[] count = new int[citations.length + 1];
        for (int i = 0; i < citations.length; i++) {
            if (citations[i] > citations.length) {
                count[citations.length]++;
            } else {
                count[citations[i]]++;
            }
        }

        int total = 0;
        int res = 0;

        for (int i = citations.length; i >= 0; i--) {
            total += count[i];
            if (total >= i) return i;
        }

        return 0;
    }
}
