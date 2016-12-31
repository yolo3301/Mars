public class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> first = new ArrayList<>();
        if (s.length() == 0) return res;

        List<List<List<String>>> mem = new ArrayList<>();
        List<String> ff = new ArrayList<>();
        ff.add("" + s.charAt(0));
        first.add(ff);
        mem.add(first);

        boolean[][] isPan = new boolean[s.length()][s.length()];
        isPan[0][0] = true;

        for (int i = 1; i < s.length(); i++) {
            List<List<String>> curr = new ArrayList<>();
            for (int j = i; j >= 0; j--) {
                if (s.charAt(j) == s.charAt(i) && (j + 1 > i - 1 || isPan[j+1][i-1])) {
                    isPan[j][i] = true;
                    String str = s.substring(j, i + 1);
                    if (j - 1 >= 0) {
                        for (List<String> l : mem.get(j-1)) {
                            List<String> list = new ArrayList<>(l);
                            list.add(str);
                            curr.add(list);
                        }
                    } else {
                        List<String> list = new ArrayList<>();
                        list.add(str);
                        curr.add(list);
                    }
                }
            }
            mem.add(curr);
        }

        return mem.get(s.length() - 1);
    }
}
