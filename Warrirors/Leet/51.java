public class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        bt(n, 0, new ArrayList<>(), res);
        return res;
    }

    private void bt(int n, int index, List<String> buffer, List<List<String>> res) {
        if (index == n) {
            res.add(new ArrayList<>(buffer));
            return;
        }

        char[] chs = new char[n];
        Arrays.fill(chs, '.');

        for (int i = 0; i < n; i++) {
            boolean go = true;
            for (int j = 1; index - j >= 0; j++) {
                if (buffer.get(index - j).charAt(i) == 'Q') {
                    go = false;
                    break;
                }
            }
            if (go) {
                for (int j = 1; i - j >= 0 && index - j >= 0; j++) {
                    if (buffer.get(index - j).charAt(i - j) == 'Q') {
                        go = false;
                        break;
                    }
                }
            }
            if (go) {
                for (int j = 1; i + j < n && index - j >= 0; j++) {
                    if (buffer.get(index - j).charAt(i + j) == 'Q') {
                        go = false;
                        break;
                    }
                }
            }

            if (go) {
                chs[i] = 'Q';
                String curr = new String(chs);
                buffer.add(curr);
                bt(n, index + 1, buffer, res);
                buffer.remove(buffer.size() - 1);
                chs[i] = '.';
            }
        }
    }
}
