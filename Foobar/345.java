class Solution {
    public String reverseVowels(String s) {
        char[] ch = s.toCharArray();
        int i = 0, j = s.length()-1;

        Set<Character> set = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'));

        while (i < j) {
            while (i < j && !set.contains(ch[i])) i++;
            while (i < j && !set.contains(ch[j])) j--;

            if (i != j) {
                char tmp = ch[i];
                ch[i] = ch[j];
                ch[j] = tmp;
                i++;
                j--;
            }
        }

        return new String(ch);
    }
}
