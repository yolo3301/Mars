class Solution {
    public boolean checkValidString(String s) {
        return bt(s, 0, 0);
    }

    private boolean bt(String s, int index, int left) {
        if (index == s.length())
            return left == 0;

        if (s.charAt(index) == '(') return bt(s, index+1, left+1);
        else if (s.charAt(index) == ')') {
            if (left == 0) return false;
            return bt(s, index+1, left-1);
        } else {
            // case *
            if (bt(s, index+1, left)) return true;
            if (bt(s, index+1, left+1)) return true;
            if (left > 0 && bt(s, index+1, left-1)) return true;
            return false;
        }
    }
}