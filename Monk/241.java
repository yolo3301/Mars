public class Solution {
    private HashMap<String, List<Integer>> memo = new HashMap<>();
    public List<Integer> diffWaysToCompute(String input) {
        if (memo.containsKey(input)) return memo.get(input);

        List<Integer> res = new ArrayList<>();

        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);
            List<Integer> left = new ArrayList<>();
            List<Integer> right = new ArrayList<>();
            if (ch == '+' || ch == '-' || ch == '*') {
                left = diffWaysToCompute(input.substring(0, i));
                right = diffWaysToCompute(input.substring(i + 1));
            }

            for (Integer l : left) {
                for (Integer r : right) {
                    if (ch == '+') res.add(l + r);
                    else if (ch == '-') res.add(l - r);
                    else if (ch == '*') res.add(l * r);
                }
            }
        }

        if (res.isEmpty()) res.add(Integer.valueOf(input));

        memo.put(input, res);

        return res;
    }
}