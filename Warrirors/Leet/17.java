public class Solution {
    private char[][] map = new char[][] {
        {'a','b','c'},
        {'d','e','f'},
        {'g','h','i'},
        {'j','k','l'},
        {'m','n','o'},
        {'p','q','r','s'},
        {'t','u','v'},
        {'w','x','y','z'}
    };

    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        if (digits.isEmpty()) return res;
        bt(digits.toCharArray(), 0, "", res);
        return res;
    }

    private void bt(char[] chs, int index, String buffer, List<String> res) {
        if (index == chs.length) {
            res.add(buffer);
            return;
        }

        int curr = chs[index] - '0' - 2;
        for (char ch : map[curr]) {
            bt(chs, index + 1, buffer + ch, res);
        }
    }
}
