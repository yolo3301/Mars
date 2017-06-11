public class Solution {
    public String findContestMatch(int n) {
        List<String> parts = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            parts.add(Integer.toString(i));
        }
        helper(parts);
        return res;
    }

    String res = null;

    private void helper(List<String> parts) {
        if (parts.size() == 1) {
            res = parts.get(0);
            return;
        }

        List<String> next = new ArrayList<>();
        for (int i = 0; i < parts.size()/2; i++) {
            String v1 = parts.get(i);
            String v2 = parts.get(parts.size()-1-i);
            String v = "("+v1+","+v2+")";
            next.add(v);
        }

        helper(next);
    }
}