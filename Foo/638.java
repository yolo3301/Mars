public class Solution {
    public int shoppingOffers(List<Integer> price, List<List<Integer>> special, List<Integer> needs) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < needs.size(); i++) {
            sb.append(0).append(';');
        }
        clear = sb.toString();

        return bt(needs, price, special, new HashMap<>());
    }

    String clear;

    private int bt(List<Integer> needs, List<Integer> price, List<List<Integer>> special, Map<String, Integer> memo) {
        String key = getKey(needs);
        if (key.equals(clear)) return 0;
        if (memo.containsKey(key)) return memo.get(key);

        int min = Integer.MAX_VALUE;
        boolean spApply = false;

        for (List<Integer> sp : special) {
            boolean apply = true;
            int localSum = 0;
            for (int j = 0; j < needs.size(); j++) {
                localSum += (sp.get(j) * price.get(j));
                needs.set(j, needs.get(j)-sp.get(j));
                if (needs.get(j) < 0) apply = false;
            }
            
            if (sp.get(sp.size()-1) > localSum) apply = false;

            if (apply) {
                spApply = true;
                min = Math.min(min, bt(needs, price, special, memo) + sp.get(sp.size()-1));
            }

            for (int j = 0; j < needs.size(); j++) {
                needs.set(j, needs.get(j)+sp.get(j));
            }
        }
        
        if (!spApply) {
            for (int j = 0; j < needs.size(); j++) {
                if (needs.get(j) > 0) {
                    needs.set(j, needs.get(j)-1);
                    min = Math.min(min, bt(needs, price, special, memo) + price.get(j));
                    needs.set(j, needs.get(j)+1);
                }
            }
        }

        memo.put(key, min);
        return min;
    }

    private String getKey(List<Integer> needs) {
        StringBuilder sb = new StringBuilder();
        for (int i : needs) {
            sb.append(i).append(';');
        }
        return sb.toString();
    }
}

public class Solution {
    public int shoppingOffers(List < Integer > price, List < List < Integer >> special, List < Integer > needs) {
        return shopping(price, special, needs, 0);
    }
    public int shopping(List < Integer > price, List < List < Integer >> special, List < Integer > needs, int i) {
        if (i == special.size())
            return dot(needs, price);
        ArrayList < Integer > clone = new ArrayList < > (needs);
        int j = 0;
        for (j = 0; j < special.get(i).size() - 1; j++) {
            int diff = clone.get(j) - special.get(i).get(j);
            if (diff < 0)
                break;
            clone.set(j, diff);
        }
        if (j == special.get(i).size() - 1)
            return Math.min(special.get(i).get(j) + shopping(price, special, clone, i), shopping(price, special, needs, i + 1));
        else
            return shopping(price, special, needs, i + 1);
    }
    public int dot(List < Integer > a, List < Integer > b) {
        int sum = 0;
        for (int i = 0; i < a.size(); i++) {
            sum += a.get(i) * b.get(i);
        }
        return sum;
    }
}