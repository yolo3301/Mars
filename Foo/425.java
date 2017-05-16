public class Solution {
    public List<List<String>> wordSquares(String[] words) {
        List<List<String>> res = new ArrayList<>();
        if (words.length == 0) return res;
        Trie trie = new Trie();
        Set<String> pool = new HashSet<>();
        for (String w : words) {
            trie.add(w);
            pool.add(w);
        }

        bt(pool, new String[words[0].length()], 0, trie, res);
        return res;
    }

    private void bt(Set<String> pool, String[] words, int index, Trie trie, List<List<String>> res) {
        if (index == words.length) {
            res.add(new ArrayList<>(Arrays.asList(words)));
            return;
        }

        StringBuilder sb = new StringBuilder();
        for (int j = 0; j < index; j++) {
            sb.append(words[j].charAt(index));
        }
        String prefix = sb.toString();
        Set<String> usable = pool;
        if (index > 0) usable = trie.matchPrefix(prefix);

        for (String next : usable) {
            words[index] = next;
            bt(pool, words, index+1, trie, res);
        }
    }

    public class Trie {
        public class Node {
            public Set<String> words;
            public Node[] children;
            public boolean isEnd;
            public Node() {
                words = new HashSet<>();
                children = new Node[26];
                isEnd = false;
            }
        }

        public Node root;

        public Trie() {
            root = new Node();
        }

        public void add(String word) {
            if (root.words.contains(word)) return;

            Node p = root;
            for (char ch : word.toCharArray()) {
                p.words.add(word);
                if (p.children[ch - 'a'] == null) {
                    p.children[ch - 'a'] = new Node();
                }
                p = p.children[ch - 'a'];
            }
            p.words.add(word);
            p.isEnd = true;
        }

        public Set<String> matchPrefix(String prefix) {
            if (prefix.length() == 0) return root.words;
            Node p = root;
            for (char ch : prefix.toCharArray()) {
                if (p.children[ch - 'a'] != null) {
                    p = p.children[ch - 'a'];
                } else {
                    p = null;
                    break;
                }
            }

            if (p == null) return new HashSet<>();
            return p.words;
        }
    }
}