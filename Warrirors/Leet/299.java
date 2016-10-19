public class Solution {
    public String getHint(String secret, String guess) {
        Map<Character, Integer> count = new HashMap<>();
        int a = 0, b = 0;
        for (int i = 0; i < secret.length(); i++) {
            if (secret.charAt(i) == guess.charAt(i)) {
                a++;
            } else {
                char c = secret.charAt(i);
                if (count.containsKey(c)) {
                    count.put(c, count.get(c) + 1);
                } else {
                    count.put(c, 1);
                }
            }
        }

        for (int i = 0; i < secret.length(); i++) {
            if (secret.charAt(i) != guess.charAt(i)) {
                char c = guess.charAt(i);
                if (count.containsKey(c) && count.get(c) > 0) {
                    b++;
                    count.put(c, count.get(c) - 1);
                }
            }
        }

        return a + "A" + b + "B";
    }
}
