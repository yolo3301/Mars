class Solution {
    int index = 0;
    public int calculate(String s) {
        int ret = 0;
        int curMark = 1;
        while (index < s.length()) {
            if (s.charAt(index) == ')') {
                index++;
                break;
            } else if (s.charAt(index) == '(') {
                index++;
                int val = calculate(s) * curMark;
                curMark = 1;

                ret += val;
            } else if (!Character.isDigit(s.charAt(index))) {
                if (s.charAt(index) == '+') curMark = 1;
                else if (s.charAt(index) == '-') curMark = -1;
                index++;
            } else {
                int j = index;
                while (j < s.length() && Character.isDigit(s.charAt(j)))
                    j++;

                int val = Integer.valueOf(s.substring(index, j)) * curMark;
                curMark = 1;

                ret += val;
                index = j;
            }
        }

        return ret;
    }
}