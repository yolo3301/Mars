public class WordDictionary {

    private Node root;

    public class Node {
        public Map<Character, Node> children;
        public boolean wordEnd;
        public Node() {
            children = new HashMap<>();
            wordEnd = false;
        }
    }

    public WordDictionary() {
        root = new Node();
    }

    // Adds a word into the data structure.
    public void addWord(String word) {
        if (word == null || word.isEmpty()) return;
        Node n = root;
        for (char ch : word.toCharArray()) {
            if (!n.children.containsKey(ch)) {
                n.children.put(ch, new Node());
            }
            n = n.children.get(ch);
        }

        n.wordEnd = true;
    }

    // Returns if the word is in the data structure. A word could
    // contain the dot character '.' to represent any one letter.
    public boolean search(String word) {
        if (word == null || word.isEmpty()) return false;
        return tryMatch(word.toCharArray(), 0, root);
    }

    private boolean tryMatch(char[] chs, int index, Node node) {
        if (chs.length == index) return node.wordEnd;

        char curr = chs[index];
        if (curr != '.') return node.children.containsKey(curr) && tryMatch(chs, index + 1, node.children.get(curr));

        boolean res = false;
        for (char c : node.children.keySet()) {
            res |= tryMatch(chs, index + 1, node.children.get(c));
        }

        return res;
    }
}

// Your WordDictionary object will be instantiated and called as such:
// WordDictionary wordDictionary = new WordDictionary();
// wordDictionary.addWord("word");
// wordDictionary.search("pattern");
