public class Solution {
    Map<String, List<Integer>> memo = new HashMap<>();
    public List<Integer> diffWaysToCompute(String input) {
        if (memo.containsKey(input)) return memo.get(input);
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);
            if (ch == '+' || ch == '-' || ch == '*') {
                List<Integer> left = diffWaysToCompute(input.substring(0,i));
                List<Integer> right = diffWaysToCompute(input.substring(i+1));
                for (int l : left) {
                    for (int r : right) {
                        if (ch == '+') res.add(l+r);
                        else if (ch == '-') res.add(l-r);
                        else if (ch == '*') res.add(l*r);
                    }
                }
            }
        }

        if (res.isEmpty()) res.add(Integer.parstInt(input));
        memo.put(input, res);

        return res;
    }
}