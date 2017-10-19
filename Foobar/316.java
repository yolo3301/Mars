class Solution {
    public String removeDuplicateLetters(String s) {
        int[] cnt = new int[26];
        for (char ch : s.toCharArray()) {
            cnt[ch - 'a']++;
        }

        int[] appeared = new int[26];
        Stack<Character> stack = new Stack<>();
        for (char ch : s.toCharArray()) {
            cnt[ch - 'a']--;
            if (appeared[ch - 'a'] > 0) continue;
            
            while (!stack.empty() && cnt[stack.peek() - 'a'] > 0 && ch < stack.peek()) {
                appeared[stack.pop() - 'a']--;
            }

            if (appeared[ch - 'a'] == 0) {
                stack.push(ch);
                appeared[ch - 'a'] = 1;
            }
        }

        StringBuilder sb = new StringBuilder();
        while (!stack.empty()) {
            sb.insert(0, stack.pop());
        }

        return sb.toString();
    }
}

