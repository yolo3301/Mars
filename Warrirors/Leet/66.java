public class Solution {
    public int[] plusOne(int[] digits) {
        List<Integer> list = new ArrayList<>();
        int f = digits[digits.length - 1] + 1;
        int c = f / 10;
        list.add(f % 10);

        for (int i = digits.length - 2; i >= 0; i--) {
            int k = digits[i] + c;
            c = k / 10;
            list.add(k % 10);
        }

        if (c != 0) list.add(c);

        Collections.reverse(list);

        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}
