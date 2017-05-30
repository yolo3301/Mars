public class Solution {
    public boolean validWordSquare(List<String> words) {
        for (int i = 0; i < words.size(); i++) {
            int len = words.get(i).length();
            int j = 0;
            for ( ; j < len && j < words.size(); j++) {
                if (words.get(j).length() < i+1 || words.get(j).charAt(i) != words.get(i).charAt(j))
                    return false;
            }
            // more rows than cols
            for ( ; j < words.size(); j++) {
                if (words.get(j).length() > i)
                    return false;
            }
            // more cols than rows
            if (j < len)
                return false;
        }

        return true;
    }
}