// so stupid
public class Solution {
    public String reverseWords(String s) {
        String[] parts = s.split(" ");
        StringBuilder sb = new StringBuilder();
        for (int i = parts.length - 1; i >= 0; i--) {
            if (parts[i] != null && !parts[i].isEmpty()) {
                sb.append(parts[i]);
                sb.append(' ');
            }
        }
        return sb.toString().trim();
    }
}


public class Solution {
    public String reverseWords(String s) {
        if (s.trim().isEmpty()) return "";
        char[] chs = s.trim().toCharArray();
        reverse(chs, 0, chs.length - 1);
        int j = 0;
        for (int i = 0; i < chs.length; i++) {
            if (chs[i] == ' ') {
                reverse(chs, j, i - 1);
                j = i + 1;
            }
        }

        reverse(chs, j, chs.length - 1);

        return new String(chs);
    }

    private void reverse(char[] chs, int s, int e) {
        int i = s, j = e;
        while (i < j) {
            char tmp = chs[i];
            chs[i] = chs[j];
            chs[j] = tmp;
            i++;
            j--;
        }
    }
}
