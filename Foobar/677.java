class MapSum {

    class TrieNode {
        public int val;
        public TrieNode[] children;
        public TrieNode() {
            this.val = 0;
            this.children = new TrieNode[26];
        }

        public void add(String str, int index, int diff) {
            this.val += diff;
            if (index == str.length()) {
                return;
            }

            char curr = str.charAt(index);
            if (this.children[curr - 'a'] == null)
                this.children[curr - 'a'] = new TrieNode();
            this.children[curr - 'a'].add(str, index+1, diff);
        }

        public int matchPrefix(String str, int index) {
            if (index == str.length()) {
                return this.val;
            }

            char curr = str.charAt(index);
            if (this.children[curr - 'a'] == null) return 0;
            return this.children[curr - 'a'].matchPrefix(str, index+1);
        }
    }

    Map<String, Integer> map;
    TrieNode root;

    /** Initialize your data structure here. */
    public MapSum() {
        this.map = new HashMap<>();
        this.root = new TrieNode();
    }
    
    public void insert(String key, int val) {
        int diff = val;
        if (map.containsKey(key)) {
            diff -= map.get(key);
        }
        map.put(key, val);
        
        // System.out.println(diff);

        root.add(key, 0, diff);
    }
    
    public int sum(String prefix) {
        return root.matchPrefix(prefix, 0);
    }
}

/**
 * Your MapSum object will be instantiated and called as such:
 * MapSum obj = new MapSum();
 * obj.insert(key,val);
 * int param_2 = obj.sum(prefix);
 */