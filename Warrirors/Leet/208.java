// Achieve better performance with array instead hash map
class TrieNode {
    // Initialize your data structure here.

    private Map<Character, TrieNode> children;

    private boolean end;

    public TrieNode() {
        children = new HashMap<>();
        end = false;
    }

    public TrieNode getChild(char ch) {
        if (hasChild(ch)) {
            return children.get(ch);
        }

        return null;
    }

    public boolean hasChild(char ch) {
        return children.containsKey(ch);
    }

    public void addChild(char ch) {
        if (!hasChild(ch)) {
            children.put(ch, new TrieNode());
        }
    }

    public boolean isWordEnd() {
        return end;
    }

    public void setWordEnd() {
        end = true;
    }
}

public class Trie {
    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    // Inserts a word into the trie.
    public void insert(String word) {
        TrieNode node = root;
        for (char ch : word.toCharArray()) {
            node.addChild(ch);
            node = node.getChild(ch);
        }

        node.setWordEnd();
    }

    // Returns if the word is in the trie.
    public boolean search(String word) {
        TrieNode node = root;
        for (char ch : word.toCharArray()) {
            if (!node.hasChild(ch))
                return false;
            else
                node = node.getChild(ch);
        }

        return node.isWordEnd();
    }

    // Returns if there is any word in the trie
    // that starts with the given prefix.
    public boolean startsWith(String prefix) {
        TrieNode node = root;
        for (char ch : prefix.toCharArray()) {
            if (!node.hasChild(ch))
                return false;
            else
                node = node.getChild(ch);
        }

        return true;
    }
}

// Your Trie object will be instantiated and called as such:
// Trie trie = new Trie();
// trie.insert("somestring");
// trie.search("key");
