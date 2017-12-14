class WordFilter {
    
        TrieNode pRoot = new TrieNode();
        TrieNode sRoot = new TrieNode();
    
        public WordFilter(String[] words) {
            for (int i = 0; i < words.length; i++) {
                pRoot.add(words[i], 0, i, false);
                sRoot.add(new StringBuilder(words[i]).reverse().toString(), 0, i, true);
            }
        }
        
        public int f(String prefix, String suffix) {
            Map<String, Integer> p = pRoot.getWords(prefix, 0);
            if (p == null) return -1;
    
            Map<String, Integer> s = sRoot.getWords(new StringBuilder(suffix).reverse().toString(), 0);
            if (s == null) return -1;
    
            int ret = -1;
            for (String s1 : p.keySet()) {
                ret = Math.max(ret, s.getOrDefault(s1, -1));
            }
    
            return ret;
        }
    
        class TrieNode {
            public TrieNode[] children;
            public boolean isEnd;
            public Map<String, Integer> weights;
    
            public TrieNode() {
                isEnd = false;
                weights = new HashMap<>();
                children = new TrieNode[26];
            }
    
            public void add(String word, int index, int weight, boolean reverse) {
                if (!reverse)
                    weights.put(word, weight);
                else
                    weights.put(new StringBuilder(word).reverse().toString(), weight);
                
                if (index == word.length()) {
                    isEnd = true;
                    return;
                }
    
                char cur = word.charAt(index);
                if (children[cur - 'a'] == null)
                    children[cur - 'a'] = new TrieNode();
    
                children[cur - 'a'].add(word, index+1, weight, reverse);
            }
    
            public Map<String, Integer> getWords(String word, int index) {
                if (index == word.length()) {
                    return weights;
                }
    
                char cur = word.charAt(index);
                if (children[cur - 'a'] == null)
                    return null;
    
                return children[cur - 'a'].getWords(word, index+1);
            }
        }
    }
    
    /**
     * Your WordFilter object will be instantiated and called as such:
     * WordFilter obj = new WordFilter(words);
     * int param_1 = obj.f(prefix,suffix);
     */