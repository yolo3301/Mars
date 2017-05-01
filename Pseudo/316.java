public class Solution {
    public String removeDuplicateLetters(String s) {
        if (s.length() == 0) return s;
        Stack<Character> stack = new Stack<>();
        int[] cnt = new int[26];
        boolean[] appear = new boolean[26];
        char[] chs = s.toCharArray();
        for (char ch : chs) {
            cnt[ch - 'a']++;
        }

        for (char ch : chs) {
            cnt[ch-'a']--;
            if (appear[ch-'a']) continue;
            while (!stack.empty() && ch <= stack.peek() && cnt[stack.peek() - 'a'] > 0) {
                appear[stack.pop()-'a'] = false;
            }
            stack.push(ch);
            appear[ch-'a'] = true;
        }

        StringBuilder sb = new StringBuilder();
        while (!stack.empty()) {
            sb.insert(0, stack.pop());
        }

        return sb.toString();
    }
}