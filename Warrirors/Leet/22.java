public class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        if (n == 0) return res;
        bt(0, 0, n, "", res);

        return res;
    }

    private void bt(int left, int right, int n, String buffer, List<String> result) {
        if (buffer.length() == 2 * n) {
            result.add(buffer);
            return;
        }

        // left parenthesis
        if (left < n) {
            bt(left + 1, right, n, buffer + "(", result);
        }

        if (right < left) {
            bt(left, right + 1, n, buffer + ")", result);
        }
    }
}
