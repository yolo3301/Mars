public class Solution {
    public List<String> addOperators(String num, int target) {
        if (num.isEmpty()) return new ArrayList<>();
        Set<String> res = new HashSet<>();
        bt(num, 0, target, new LinkedList<>(), new LinkedList<>(), new LinkedList<>(), new LinkedList<>(), res);
        return new ArrayList<>(res);
    }

    private void bt(String num, int index, int target, Deque<Integer> ns, Deque<Character> os,
        Deque<Integer> ns2, Deque<Character> os2, Set<String> res) {
        if (index == num.length()) {
            int val = cal(new LinkedList<>(ns), new LinkedList<>(os));
            if (val == target) {
                res.add(genRes(new LinkedList<>(ns2), new LinkedList<>(os2)));
            }
            return;
        }

        for (int i = index; i < num.length(); i++) {
            String sub = num.substring(index, i + 1);
            long realVal = Long.valueOf(sub);
            if (realVal > Integer.MAX_VALUE) break;

            if (index == 0) {
                ns.addLast((int) realVal);
                ns2.addLast((int) realVal);
                bt(num, i + 1, target, ns, os, ns2, os2, res);
                ns.removeLast();
                ns2.removeLast();
            } else {
                // +
                ns.addLast((int) realVal);
                ns2.addLast((int) realVal);
                os.addLast('+');
                os2.addLast('+');
                bt(num, i + 1, target, ns, os, ns2, os2, res);
                os.removeLast();
                os2.removeLast();
                // -
                os.addLast('-');
                os2.addLast('-');
                bt(num, i + 1, target, ns, os, ns2, os2, res);
                os.removeLast();
                os2.removeLast();
                ns.removeLast();
                ns2.removeLast();
                // *
                int last = ns.removeLast();
                long toPush = realVal * last;
                ns.addLast((int) toPush);
                ns2.addLast((int) realVal);
                os2.addLast('*');
                bt(num, i + 1, target, ns, os, ns2, os2, res);
                ns.removeLast();
                ns.addLast(last);
                ns2.removeLast();
                os2.removeLast();
            }

            if (realVal == 0) break;
        }
    }

    private int cal(Deque<Integer> ns, Deque<Character> os) {
        while (!os.isEmpty()) {
            int v1 = ns.removeFirst();
            int v2 = ns.removeFirst();
            char op = os.removeFirst();
            if (op == '+') {
                ns.push(v1 + v2);
            } else {
                ns.push(v1 - v2);
            }
        }

        return ns.removeFirst();
    }

    private String genRes(Deque<Integer> ns, Deque<Character> os) {
        StringBuilder sb = new StringBuilder();
        while (!os.isEmpty()) {
            sb.append(ns.removeFirst());
            sb.append(os.removeFirst());
        }

        sb.append(ns.removeFirst());

        return sb.toString();
    }
}

// https://discuss.leetcode.com/topic/24523/java-standard-backtrace-ac-solutoin-short-and-clear
public class Solution {
    public List<String> addOperators(String num, int target) {
        List<String> rst = new ArrayList<String>();
        if(num == null || num.length() == 0) return rst;
        helper(rst, "", num, target, 0, 0, 0);
        return rst;
    }
    public void helper(List<String> rst, String path, String num, int target, int pos, long eval, long multed){
        if(pos == num.length()){
            if(target == eval)
                rst.add(path);
            return;
        }
        for(int i = pos; i < num.length(); i++){
            if(i != pos && num.charAt(pos) == '0') break;
            long cur = Long.parseLong(num.substring(pos, i + 1));
            if(pos == 0){
                helper(rst, path + cur, num, target, i + 1, cur, cur);
            }
            else{
                helper(rst, path + "+" + cur, num, target, i + 1, eval + cur , cur);

                helper(rst, path + "-" + cur, num, target, i + 1, eval -cur, -cur);

                helper(rst, path + "*" + cur, num, target, i + 1, eval - multed + multed * cur, multed * cur );
            }
        }
    }
}
