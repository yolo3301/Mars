/*
Letter Combinations of a Phone Number
*/

public class Solution {
    private Map<Character, String> map;
    
    private void initTable() {
        map = new HashMap<Character, String>();
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");
    }
    
    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<String>();
        if (digits == null || digits.length() == 0)
            return res;
            
        initTable();
        helper(digits, 0, new String(), res);
        return res;
    }
    
    private void helper(String digits, int index, String tmp, List<String> res) {
        if (tmp.length() == digits.length()) {
            res.add(tmp);
            return;
        }
        
        char c  = digits.charAt(index);
        String target = map.get(c);
        
        for (int i = 0; i < target.length(); i++) {
            char ctmp = target.charAt(i);
            helper(digits, index + 1, tmp + ctmp, res);
        }
    }
}