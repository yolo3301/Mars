public class Solution {
    public String removeDuplicateLetters(String s) {
        int[] cnt = new int[26];
        for (char ch : s.toCharArray()) {
            cnt[ch - 'a']++;
        }

        Stack<Character> stack = new Stack<>();
        boolean[] inStack = new boolean[26];

        for (char ch : s.toCharArray()) {
            cnt[ch - 'a']--;
            if (inStack[ch - 'a']) continue;

            while (!stack.empty() && stack.peek() > ch && cnt[stack.peek() - 'a'] > 0) {
                inStack[stack.pop() - 'a'] = false;
            }

            inStack[ch - 'a'] = true;
            stack.push(ch);
        }

        StringBuilder sb = new StringBuilder();
        while (!stack.empty()) sb.insert(0, stack.pop());

        return sb.toString();
    }
}