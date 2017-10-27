class Solution {
    public String decodeString(String s) {
        return helper(s);
    }

    int index = 0;
    private String helper(String s) {
        StringBuilder sb = new StringBuilder();
        while (index < s.length() && s.charAt(index) != ']') {
            if (Character.isLetter(s.charAt(index))) {
                sb.append(s.charAt(index++));
            } else {
                int j = index;
                while (index < s.length() && Character.isDigit(s.charAt(index))) index++;

                int reps = Integer.valueOf(s.substring(j, index));
                index++;
                String next = helper(s);
                for (int i = 0; i < reps; i++) sb.append(next);
                index++;
            }
        }

        return sb.toString();
    }
}
