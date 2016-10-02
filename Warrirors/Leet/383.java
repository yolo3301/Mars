public class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        if (magazine == null) {
            return ransomNote == null;
        }

        // optimizaion 1 -- compare length
        if (magazine.length() < ransomNote.length()) return false;

        HashMap<Character, Integer> count = new HashMap<Character, Integer>();
        for (int i = 0; i < ransomNote.length(); i++) {
            if (count.containsKey(ransomNote.charAt(i))) {
                count.put(ransomNote.charAt(i), count.get(ransomNote.charAt(i)) + 1);
            } else {
                count.put(ransomNote.charAt(i), 1);
            }
        }

        int num = ransomNote.length();
        for (int j = 0; j < magazine.length(); j++) {
            if (count.containsKey(magazine.charAt(j))) {
                if (count.get(magazine.charAt(j)) > 0) {
                    count.put(magazine.charAt(j), count.get(magazine.charAt(j)) - 1);
                    // optimizaion 2 -- early exit
                    if (--num == 0) {
                        return true;
                    }
                }
            }
        }

        return num == 0;
    }
}
