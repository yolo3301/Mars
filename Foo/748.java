class Solution {
    public String shortestCompletingWord(String licensePlate, String[] words) {
        String lowered = licensePlate.toLowerCase();
        char[] cnt = new char[26];
        for (char ch : lowered.toCharArray()) {
            if (Character.isLetter(ch)) {
                cnt[ch - 'a']++;
            }
        }

        String cand = null;
        int len = Integer.MAX_VALUE;

        for (String w : words) {
            char[] local = new char[26];
            for (char ch : w.toCharArray()) {
                local[ch - 'a']++;
            }

            boolean found = true;
            for (int i = 0; i < 26; i++) {
                if (local[i] < cnt[i]) {
                    found = false;
                    break;
                }
            }

            if (found && w.length() < len) {
                cand = w;
                len = cand.length();
            }
        }

        return cand;
    }
}