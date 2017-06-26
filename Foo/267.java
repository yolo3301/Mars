public class Solution {
    public List<String> generatePalindromes(String s) {
        List<String> res = new ArrayList<>();
        Map<Character, Integer> cnt = new HashMap<>();
        for (char c : s.toCharArray()) {
            cnt.put(c, cnt.getOrDefault(c, 0)+1);
        }

        int oddCnt = 0;
        for (char c : cnt.keySet()) {
            if (cnt.get(c) % 2 == 1) oddCnt++;
        }

        if (oddCnt > 1) return res;

        bt(cnt, new char[s.length()], 0, s.length()-1, res);
        return res;
    }

    private void bt(Map<Character, Integer> cnt, char[] ch, int s, int e, List<String> res) {
        if (s > e) {
            res.add(new String(ch));
            return;
        }

        for (char c : cnt.keySet()) {
            if (s < e && cnt.get(c) >= 2) {
                ch[s] = c;
                ch[e] = c;
                cnt.put(c, cnt.get(c)-2);
                bt(cnt, ch, s+1, e-1, res);
                cnt.put(c, cnt.get(c)+2);
            } else if (s == e && cnt.get(c) == 1) {
                ch[s] = c;
                cnt.put(c, cnt.get(c)-1);
                bt(cnt, ch, s+1, e-1, res);
                cnt.put(c, cnt.get(c)+1);
            }
        }
    }
}