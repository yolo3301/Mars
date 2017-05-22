public class Solution {
    Map<String, Boolean> memo = new HashMap<>();
    public boolean canWin(String s) {
        if (memo.containsKey(s)) {
            return memo.get(s);
        }

        boolean win = false;
        for (int i = 0; i < s.length()-1; i++) {
            if (s.charAt(i) == '+' && s.charAt(i+1) == '+') {
                String next = (i>0 ? s.substring(0, i) : "") + "--" + s.substring(i+2);
                if (!canWin(next)) {
                    win = true;
                    break;
                }
            }
        }

        memo.put(s, win);

        return win;
    }
}