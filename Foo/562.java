// there is another DP solution
public class Solution {
    Map<String, Integer> v = new HashMap<>();
    Map<String, Integer> h = new HashMap<>();
    Map<String, Integer> d1 = new HashMap<>();
    Map<String, Integer> d2 = new HashMap<>();

    public int longestLine(int[][] M) {
        int m = M.length;
        if (m == 0) return 0;
        int n = M[0].length;
        if (n == 0) return 0;

        int res = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (M[i][j] != 1) continue;
                String k = getKey(i, j);
                if (!v.containsKey(k)) {
                    int tmp = maxLen(M, i, j, 0, -1);
                    maxLen(M, i, j, 0, tmp);
                    res = Math.max(res, tmp);
                }
                if (!h.containsKey(k)) {
                    int tmp = maxLen(M, i, j, 1, -1);
                    maxLen(M, i, j, 1, tmp);
                    res = Math.max(res, tmp);
                }
                if (!d1.containsKey(k)) {
                    int tmp = maxLen(M, i, j, 2, -1);
                    maxLen(M, i, j, 2, tmp);
                    res = Math.max(res, tmp);
                }
                if (!d2.containsKey(k)) {
                    int tmp = maxLen(M, i, j, 3, -1);
                    maxLen(M, i, j, 3, tmp);
                    res = Math.max(res, tmp);
                }
            }
        }

        return res;
    }

    private int maxLen(int[][] M, int x, int y, int dir, int fill) {
        int res = 0;
        int i, j;
        switch (dir) {
            case 0:
                i = x;
                while (i >= 0 && M[i][y] == 1) {
                    if (fill > 0) v.put(getKey(i, y), fill);
                    res++;
                    i--;
                }
                i = x+1;
                while (i < M.length && M[i][y] == 1) {
                    if (fill > 0) v.put(getKey(i, y), fill);
                    res++;
                    i++;
                }
                break;
            case 1:
                i = y;
                while (i >= 0 && M[x][i] == 1) {
                    if (fill > 0) h.put(getKey(x, i), fill);
                    res++;
                    i--;
                }
                i = y+1;
                while (i < M[0].length && M[x][i] == 1) {
                    if (fill > 0) h.put(getKey(x, i), fill);
                    res++;
                    i++;
                }
                break;
            case 2:
                i = x;
                j = y;
                while (i >= 0 && j >= 0 && M[i][j] == 1) {
                    if (fill > 0) d1.put(getKey(i, j), fill);
                    res++;
                    i--;
                    j--;
                }
                i = x+1;
                j = y+1;
                while (i < M.length && j < M[0].length && M[i][j] == 1) {
                    if (fill > 0) d1.put(getKey(i, j), fill);                    
                    res++;
                    i++;
                    j++;
                }
                break;
            case 3:
                i = x;
                j = y;
                while (i >= 0 && j < M[0].length && M[i][j] == 1) {
                    if (fill > 0) d2.put(getKey(i, j), fill);
                    res++;
                    i--;
                    j++;
                }
                i = x+1;
                j = y-1;
                while (j >= 0 && i < M.length && M[i][j] == 1) {
                    if (fill > 0) d2.put(getKey(i, j), fill);
                    res++;
                    i++;
                    j--;
                }
                break;
            default:
                break;
        }

        return res;
    }

    private String getKey(int x, int y) {
        return x + ";" + y;
    }
}