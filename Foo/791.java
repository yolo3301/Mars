class Solution {
    public String customSortString(String S, String T) {
        int[] index = new int[26];
        Arrays.fill(index, Integer.MAX_VALUE);
        for (int i = 0; i < S.length(); i++) {
            index[S.charAt(i) - 'a'] = i;
        }

        Character[] ch = T.chars().mapToObj(c -> (char)c).toArray(Character[]::new); 
        Arrays.sort(ch, (a, b) -> {
            return index[a - 'a'] - index[b - 'a'];
        });

        StringBuilder sb = new StringBuilder();
        for (Character c : ch) {
            sb.append(c.charValue());
        }
        
        return sb.toString();
    }
}