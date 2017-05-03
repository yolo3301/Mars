public class Solution {
    public List<String> addOperators(String num, int target) {
        List<String> res = new ArrayList<>();
        bt(num, 0, "", 0, 0, target, res);
        return res;
    }

    private void bt(String num, int index, String buffer, long eval, long prev, int target, List<String> res) {
        if (index == num.length()) {
            if (target == eval) res.add(buffer);
            return;
        }

        for (int i = index; i < num.length(); i++) {
            if (i > index && num.charAt(index) == '0') break;
            long curr = Long.parseLong(num.substring(index, i+1));
            if (index == 0) {
                bt(num, i+1, buffer+curr, curr, curr, target, res);
            } else {
                bt(num, i+1, buffer+"+"+curr, eval+curr, curr, target, res);
                bt(num, i+1, buffer+"-"+curr, eval-curr, -curr, target, res);
                bt(num, i+1, buffer+"*"+curr, eval-prev+prev*curr, prev*curr, target, res);
            }
        }
    }
}