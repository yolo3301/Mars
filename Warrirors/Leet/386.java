public class Solution {
    public List<Integer> lexicalOrder(int n) {
        List<Integer> res = new ArrayList<>();
        if (n == 0) return res;
        int curr = 1;

        for (int i = 0; i < n; i++) {
            res.add(curr);
            if (curr * 10 <= n) {
                curr *= 10;
            } else if (curr % 10 != 9 && curr + 1 <= n) {
                curr++;
            } else {
                // the tricky part
                // if (curr/10)%10 == 9, it means we have to go back one more digit
                // e.g. if n = 191, at curr = 191, if missing the while loop, the next
                // number will be (191/10)+1 = 20, but it should be 2.
                while ((curr / 10) % 10 == 9) {
                    curr /= 10;
                }
                curr = curr / 10 + 1;
            }
        }

        return res;
    }
}
