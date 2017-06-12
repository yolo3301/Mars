public class Solution {
    public int findBlackPixel(char[][] picture, int N) {
        int m = picture.length;
        if (m == 0) return 0;
        int n = picture[0].length;
        if (n == 0) return 0;

        int[] col = new int[n];
        Map<String, Integer> map = new HashMap<>();

        for (int i = 0; i < m; i++) {
            String key = scanRow(picture, i, N, col);
            if (key.length() != 0) {
                map.put(key, map.getOrDefault(key, 0)+1);
            }
        }

        int res = 0;
        for (String key : map.keySet()) {
            if (map.get(key) == N) {
                for (int j = 0; j < n; j++) {
                    if (key.charAt(j) == 'B' && col[j] == N) {
                        res += N; // N black in col[j]
                    }
                }
            }
        }

        return res;
    }

    private String scanRow(char[][] picture, int row, int N, int[] col) {
        int rowCnt = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < picture[0].length; i++) {
            if (picture[row][i] == 'B') {
                rowCnt++;
                col[i]++;
            }
            sb.append(picture[row][i]);
        }

        if (rowCnt == N) return sb.toString();
        return "";
    }
}