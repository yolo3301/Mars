public class Solution {
    public boolean detectCapitalUse(String word) {
        if (word.length() == 0) return true;
        int upperCnt = 0, lowerCnt = 0;
        for (char ch : word.toCharArray()) {
            if (Character.isUpperCase(ch)) {
                if (lowerCnt > 0) return false;
                upperCnt++;
            } else if (Character.isLowerCase(ch)) {
                if (upperCnt > 1) return false;
                lowerCnt++;
            }
        }

        return true;
    }
}