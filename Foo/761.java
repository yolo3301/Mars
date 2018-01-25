class Solution {
    public String makeLargestSpecial(String S) {
        List<String> ret = new ArrayList<>();
        int cnt = 0;
        for (int i = 0, j = 0; i < S.length(); i++) {
            if (S.charAt(i) == '1') cnt++;
            else cnt--;

            if (cnt == 0) {
                ret.add("1" + makeLargestSpecial(S.substring(j+1, i)) + "0");
                j = i+1;
            }
        }
        Collections.sort(ret, Collections.reverseOrder());
        StringBuilder sb = new StringBuilder();
        for (String s : ret) sb.append(s);
        return sb.toString();
    }
}