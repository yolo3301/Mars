public class Solution {
    public List<Integer> grayCode(int n) {
        List<Integer> list = new ArrayList<>();
        list.add(0);
        if (n == 0) return list;

        // init values
        list.add(1);
        int base = 2;

        for (int i = 2; i <= n; i++) {
            int j = list.size();
            for (int k = j - 1; k >= 0; k--) {
                list.add(base + list.get(k));
            }
            base *= 2;
        }

        return list;
    }
}
