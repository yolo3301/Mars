public class Solution {
    int i = 0;
    public int calculate(String s) {
        int res = 0;
        boolean isAdd = true;
        while (i < s.length() && s.charAt(i) != ')') {
            if (s.charAt(i) == '+') {
                isAdd = true;
                i++;
            } else if (s.charAt(i) == '-') {
                isAdd = false;
                i++;
            } else if (s.charAt(i) == ' ') {
                i++;
                continue;
            } else if (Character.isDigit(s.charAt(i))) {
                int j = i;
                while (j < s.length() && Character.isDigit(s.charAt(j))) {
                    j++;
                }

                int val = Integer.parseInt(s.substring(i, j));
                
                if (isAdd) res += val;
                else res -= val;

                i = j;
            } else if (s.charAt(i) == '(') {
                i++;
                int val = calculate(s);
                
                if (isAdd) res += val;
                else res -= val;
            }
        }
        i++; // important! to skip the )
        return res;
    }
}