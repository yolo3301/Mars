public class Solution {
    public List<String> generateAbbreviations(String word) {
        List<String> res = new ArrayList<>();
        bt(word, 0, "", res);
        return res;
    }

    private void bt(String word, int index, String buffer, List<String> res) {
        if (index == word.length()) {
            res.add(buffer);
            return;
        }

        bt(word, index+1, buffer+word.charAt(index), res);

        if (buffer.length() == 0 || !Character.isDigit(buffer.charAt(buffer.length()-1))) {
            for (int j = 1; index+j <= word.length(); j++) {
                bt(word, index+j, buffer+j, res);
            }
        }
    }
}