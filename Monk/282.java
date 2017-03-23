public class Solution {
    public List<String> addOperators(String num, int target) {
        List<String> res = new ArrayList<>();
        if (num.length() == 0) return res;
        bt(num, 0, target, "", 0, 0, res);
        return res;
    }

    private void bt(String num, int index, int target, String path, long eval, long mul, List<String> res) {
        if (index == num.length()) {
            if (target == eval) {
                res.add(path);
            }
            return;
        }

        for (int i = index; i < num.length(); i++) {
            if (num.charAt(index) == '0' && i != index) break;
            long curr = Long.valueOf(num.substring(index, i+1));
            if (index == 0) {
                bt(num, i+1, target, path+curr, curr, curr, res);
            } else {
                bt(num, i+1, target, path+"+"+curr, eval+curr, curr, res);
                bt(num, i+1, target, path+"-"+curr, eval-curr, -curr, res);
                bt(num, i+1, target, path+"*"+curr, eval-mul+mul*curr, mul*curr, res);
            }
        }
    }
}