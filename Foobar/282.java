class Solution {
    public List<String> addOperators(String num, int target) {
        List<String> ret = new ArrayList<>();
        bt(num, 0, "", 0, 0, target, ret);
        return ret;
    }

    private void bt(String num, int index, String buffer, long eval, long prev, int target, List<String> ret) {
        if (index == num.length()) {
            if (eval == target)
                ret.add(buffer);
            return;
        }

        for (int i = index; i < num.length(); i++) {
            if (i > index && num.charAt(index) == '0') break;
            long cur = Long.valueOf(num.substring(index, i+1));
            if (index == 0) {
                bt(num, i+1, Long.toString(cur), cur, cur, target, ret);
            } else {
                bt(num, i+1, buffer+"+"+Long.toString(cur), eval+cur, cur, target, ret);
                bt(num, i+1, buffer+"-"+Long.toString(cur), eval-cur, -cur, target, ret);
                bt(num, i+1, buffer+"*"+Long.toString(cur), eval-prev+cur*prev, cur*prev, target, ret);
            }
        }
    }
}