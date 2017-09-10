class MagicDictionary {

    private TrieNode root;

    /** Initialize your data structure here. */
    public MagicDictionary() {
        this.root = new TrieNode();
    }
    
    /** Build a dictionary through a list of words */
    public void buildDict(String[] dict) {
        for (String w : dict) {
            this.root.add(w, 0);
        }
    }
    
    /** Returns if there is any word in the trie that equals to the given word after modifying exactly one character */
    public boolean search(String word) {
        return this.root.fuzzyMatch(word, 0, false);
    }
    
    class TrieNode {
        public TrieNode[] children;
        public boolean isEnd;

        public TrieNode() {
            this.children = new TrieNode[26];
            this.isEnd = false;
        }

        public void add(String word, int index) {
            if (index == word.length()) {
                this.isEnd = true;
                return;
            }

            char curr = word.charAt(index);
            if (children[curr - 'a'] == null) {
                children[curr - 'a'] = new TrieNode();
            }

            children[curr - 'a'].add(word, index+1);
        }

        public boolean fuzzyMatch(String word, int index, boolean prevMismatch) {
            if (index == word.length()) {
                // System.out.println(word + " " + prevMismatch);
                return this.isEnd && prevMismatch;
            }

            char curr = word.charAt(index);
            if (prevMismatch) {
                if (this.children[curr - 'a'] == null) return false;
                return this.children[curr - 'a'].fuzzyMatch(word, index+1, prevMismatch);
            }

            for (int i = 0; i < 26; i++) {
                if (this.children[i] != null) {
                    if (this.children[i].fuzzyMatch(word, index+1, i != curr - 'a'))
                        return true;
                }
            }

            return false;
        }
    }
}

/**
 * Your MagicDictionary object will be instantiated and called as such:
 * MagicDictionary obj = new MagicDictionary();
 * obj.buildDict(dict);
 * boolean param_2 = obj.search(word);
 */