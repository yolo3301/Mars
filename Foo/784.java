class Solution {
    public List<String> letterCasePermutation(String S) {
        List<String> ret = new ArrayList<>();
        bt(S, 0, new StringBuilder(), ret);
        return ret;
    }

    private void bt(String S, int index, StringBuilder sb, List<String> ret) {
        if (index == S.length()) {
            ret.add(sb.toString());
            return;
        }

        if (Character.isLetter(S.charAt(index))) {
            if (Character.isLowerCase(S.charAt(index))) {
                sb.append(Character.toUpperCase(S.charAt(index)));
            } else {
                sb.append(Character.toLowerCase(S.charAt(index)));
            }
            bt(S, index+1, sb, ret);
            sb.deleteCharAt(index);
        }

        sb.append(S.charAt(index));
        bt(S, index+1, sb, ret);
        sb.deleteCharAt(index);
    }
}