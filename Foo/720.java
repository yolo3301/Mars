class Solution {
    public String longestWord(String[] words) {
        Arrays.sort(words, (a, b) -> {
            if (a.length() != b.length()) return b.length() - a.length();
            return a.compareTo(b);
        });

        Set<String> dict = new HashSet<>();
        for (String w : words) {
            dict.add(w);
        }

        String cand = null;
        for (int i = 0; i < words.length; i++) {
            if (check(words[i], dict)) {
                cand = words[i];
                break;
            }            
        }

        return cand == null ? "" : cand;
    }

    private boolean check(String w, Set<String> dict) {
        while (w.length() > 0 && dict.contains(w)) {
            w = w.substring(0, w.length()-1);
        }

        return w.length() == 0;
    }
}