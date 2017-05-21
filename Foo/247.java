public class Solution {
    public List<String> findStrobogrammatic(int n) {
        List<String> res = new ArrayList<>();
        if (n == 0) return res;
        bt(0, (n+1)/2, n%2==1, "", res);
        return res;
    }

    int[] cand = new int[] {0, 1, 6, 8, 9};

    private void bt(int index, int half, boolean isOdd, String buffer, List<String> res) {
        if (index == half) {
            res.add(generate(buffer, isOdd));
            return;
        }

        for (int j : cand) {
            if (index == 0 && j == 0 && (half != 1 || half == 1 && !isOdd)) continue;
            if (index == half-1 && isOdd && (j == 6 || j == 9)) continue;
            bt(index+1, half, isOdd, buffer+j, res);
        }
    }

    private String generate(String half, boolean isOdd) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < (isOdd ? half.length()-1 : half.length()); i++) {
            if (half.charAt(i) == '6') {
                sb.insert(0, 9);
            } else if (half.charAt(i) == '9') {
                sb.insert(0, 6);
            } else {
                sb.insert(0, half.charAt(i));
            }
        }

        sb.insert(0, half);
        return sb.toString();
    }
}