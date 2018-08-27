class Solution {
    public boolean backspaceCompare(String S, String T) {
        Stack<Character> s1 = new Stack<>();
        Stack<Character> s2 = new Stack<>();

        for (int i = 0; i < S.length(); i++) {
            if (S.charAt(i) == '#') {
                if (!s1.empty()) s1.pop();
            } else {
                s1.push(S.charAt(i));
            }
        }
        for (int i = 0; i < T.length(); i++) {
            if (T.charAt(i) == '#') {
                if (!s2.empty()) s2.pop();
            } else {
                s2.push(T.charAt(i));
            }
        }

        while (!s1.empty() && !s2.empty()) {
            if (s1.pop() != s2.pop()) return false;
        }

        return s1.empty() && s2.empty();
    }
}