public class Solution {
    // An IP, each field is between 0 - 255
    // but each field cannot start with 0
    public List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList<>();
        bt(s, 0, 1, "", res);
        return res;
    }

    private void bt(String s, int index, int part, String buffer, List<String> res) {
        // Be careful with the termination case
        if (part == 5 && index < s.length()) return;
        if (index == s.length()) {
            if (part == 5) {
                res.add(buffer);
                return;
            } else {
                return;
            }
        }

        if (s.charAt(index) == '0') {
            bt(s, index + 1, part + 1, part == 4 ? buffer + "0" : buffer + "0.", res);
        } else {
            for (int i = index + 1; i <= index + 3 && i <= s.length(); i++) {
                String str = s.substring(index, i);
                int val = Integer.valueOf(str);
                if (val <= 255) {
                    bt(s, i, part + 1, part == 4 ? buffer + str : buffer + str + ".", res);
                }
            }
        }
    }
}
