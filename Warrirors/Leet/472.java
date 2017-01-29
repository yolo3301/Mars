public class Solution {
    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        Arrays.sort(words, new Comparator<String>() {
            public int compare(String v1, String v2) {
                return v1.length() - v2.length();
            }
        });

        List<String> res = new ArrayList<>();
        Trie trie = new Trie();
        for (String w : words) {
            if (trie.breakable(w) > 1) res.add(w);
            trie.add(w);
        }

        return res;
    }

    public class Trie {
        public class TrieNode {
            public TrieNode[] children;
            public boolean isEnd;
            public TrieNode() {
                children = new TrieNode[26];
                isEnd = false;
            }
        }

        private TrieNode root;

        public Trie() {
            root = new TrieNode();
        }

        public void add(String word) {
            TrieNode p = root;
            for (char ch : word.toCharArray()) {
                if (p.children[ch - 'a'] == null) {
                    p.children[ch - 'a'] = new TrieNode();
                }
                p = p.children[ch - 'a'];
            }

            p.isEnd = true;
        }

        public int breakable(String word) {
            if (word.length() == 0) return 0;

            TrieNode p = root;
            for (int i = 0; i < word.length(); i++) {
                char ch = word.charAt(i);
                if (p.children[ch - 'a'] == null) return 0;
                p = p.children[ch - 'a'];
                if (p.isEnd) {
                    if (i == word.length() - 1) return 1;
                    else {
                        int tmp = breakable(word.substring(i+1));
                        if (tmp != 0) return tmp + 1;
                    }
                }
            }

            return 0;
        }
    }
}