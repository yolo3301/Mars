class Solution {
    public int hIndex(int[] citations) {
        int[] index = new int[citations.length+1];
        for (int c : citations) {
            if (c >= citations.length) index[citations.length]++;
            else index[c]++;
        }

        int cnt = 0;
        for (int j = citations.length; j >= 0; j--) {
            cnt += index[j];
            if (cnt >= j) return j;
        }

        return 0;
    }
}

// [3, 0, 6, 1, 5]
// [0, 0, 0, 1, 0, 2]
// [0, 1, 2, 3, 4, 5]