public class Solution {

    public class TrieNode {
        public TrieNode[] children;
        public boolean isEnd;
        public String word;
        public TrieNode() {
            this.children = new TrieNode[26];
            this.word = null;
        }

        public void add(String str, int index) {
            if (index == str.length()) {
                this.word = str;
                return;
            }

            char curr = str.charAt(index);
            if (children[curr - 'a'] == null) {
                children[curr - 'a'] = new TrieNode();
            }
            children[curr - 'a'].add(str, index+1);
        }

        public String findMatch(String str, int index) {
            if (index == str.length()) return this.word;
            if (this.word != null) return this.word;

            char curr = str.charAt(index);
            if (children[curr - 'a'] == null) return null;
            return children[curr - 'a'].findMatch(str, index+1);
        }
    }

    public String replaceWords(List<String> dict, String sentence) {
        TrieNode root = new TrieNode();
        for (String r : dict) root.add(r, 0);

        String[] w = sentence.split(" ");
        StringBuilder res = new StringBuilder();

        for (int i = 0; i < w.length; i++) {
            String r = root.findMatch(w[i], 0);
            if (r == null) res.append(w[i]);
            else res.append(r);
            if (i != w.length-1) res.append(' ');
        }

        return res.toString();
    }
}