class Solution {
    public int uniqueMorseRepresentations(String[] words) {
        String[] code = new String[]{".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};
        Set<String> set = new HashSet<>();
        for (String s : words) {
            StringBuilder sb = new StringBuilder();
            for (char ch : s.toCharArray()) {
                sb.append(code[ch - 'a']);
            }
            set.add(sb.toString());
        }

        return set.size();
    }
}