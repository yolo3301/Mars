// More subtle solution
public class Solution {
    public String removeDuplicateLetters(String s) {
        if (s.isEmpty()) return s;
        int[] cnt = new int[26];
        int pos = 0;  // record the smallest char seen so far
        for (int i = 0; i < s.length(); i++) cnt[s.charAt(i) - 'a']++;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) < s.charAt(pos)) pos = i;
            // once some char run out of dups, then break
            if (--cnt[s.charAt(i) - 'a'] == 0) break;
        }

        // at this point, s.substring(pos+1) should only have dup chars
        return s.charAt(pos) + removeDuplicateLetters(s.substring(pos+1).replaceAll("" + s.charAt(pos), ""));
    }
}

// Faster and easy to understand
public class Solution {
    public String removeDuplicateLetters(String s) {
        if (s.isEmpty()) return s;
        int[] cnt = new int[26];
        boolean[] visited = new boolean[26];
        Stack<Character> stack = new Stack<>();
        char[] chs = s.toCharArray();

        for (char ch : chs) cnt[ch - 'a']++;

        for (char ch : chs) {
            int index = ch - 'a';

            cnt[index]--;

            if (visited[index])
                continue;

            // if the current char is smaller than the top of stack and
            // the top of stack still have more dups
            // then it's safe to remove the top
            while (!stack.empty() && stack.peek() > ch && cnt[stack.peek() - 'a'] != 0) {
                visited[stack.pop() - 'a'] = false;
            }

            stack.push(ch);
            visited[index] = true;
        }

        StringBuilder sb = new StringBuilder();
        while (!stack.empty()) sb.append(stack.pop());

        return sb.reverse().toString();
    }
}
