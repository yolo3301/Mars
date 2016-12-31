public class Solution {
    public String largestNumber(int[] nums) {
        if (nums.length == 0) return "";
        Integer[] arr = Arrays.stream(nums).boxed().toArray(Integer[]::new);
        Arrays.sort(arr, new Comparator<Integer>() {
            public int compare(Integer v1, Integer v2) {
                if (v1.equals(v2)) return 0;
                String s1 = v1.toString() + v2.toString();
                String s2 = v2.toString() + v1.toString();
                int i = 0, j = 0;
                while (i < s1.length() && j < s2.length()) {
                    char ch1 = s1.charAt(i++);
                    char ch2 = s2.charAt(j++);
                    if (ch1 != ch2) return ch2 - ch1;
                }

                return 0;
            }
        });

        StringBuilder sb = new StringBuilder();
        for (Integer n : arr) {
            if (n == 0 && sb.length() == 0) continue;
            sb.append(n);
        }

        return sb.length() == 0 ? "0" : sb.toString();
    }
}
