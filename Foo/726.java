class Solution {
    public String countOfAtoms(String formula) {
        TreeMap<String, Integer> cnt = cal(formula);
        StringBuilder sb = new StringBuilder();
        for (String elem : cnt.keySet()) {
            sb.append(elem);
            int v = cnt.get(elem);
            if (v > 1) sb.append(v);
        }

        return sb.toString();
    }

    int index = 0;

    private TreeMap<String, Integer> cal(String formula) {
        TreeMap<String, Integer> ret = new TreeMap<>();
        while (index < formula.length()) {
            if (formula.charAt(index) == ')') {
                int j = ++index;
                while (j < formula.length() && Character.isDigit(formula.charAt(j)))
                    j++;

                int cnt = 1;
                if (j > index) {
                    cnt = Integer.valueOf(formula.substring(index, j));
                }

                for (String k : ret.keySet()) {
                    ret.put(k, cnt * ret.get(k));
                }
                
                index = j;

                break;
            }

            if (formula.charAt(index) == '(') {
                index++;
                TreeMap<String, Integer> recur = cal(formula);
                for (String k : recur.keySet()) {
                    ret.put(k, ret.getOrDefault(k, 0) + recur.get(k));
                }
            } else {
                int j = index+1;
                while (j < formula.length() && Character.isLowerCase(formula.charAt(j)))
                    j++;

                String elem = formula.substring(index, j);

                index = j;
                while (j < formula.length() && Character.isDigit(formula.charAt(j)))
                    j++;

                int cnt = 1;
                if (j > index) {
                    cnt = Integer.valueOf(formula.substring(index, j));
                }

                ret.put(elem, ret.getOrDefault(elem, 0) + cnt);
                index = j;
            }
        }

        return ret;
    }
}