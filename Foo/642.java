public class AutocompleteSystem {

    public class TrieNode {
        public TrieNode[] children;
        public TrieNode space;
        public String str;
        public int count;
        public TrieNode() {
            children = new TrieNode[26];
            space = null;
            str = null;
            count = 0;
        }

        public void add(String str, int index, int count) {
            if (index == str.length()) {
                this.str = str;
                this.count = count;
                return;
            }

            char curr = str.charAt(index);
            if (curr != ' ') {
                if (children[curr - 'a'] == null)
                    children[curr - 'a'] = new TrieNode();
                children[curr - 'a'].add(str, index+1, count);
            } else if (curr == ' ') {
                if (space == null)
                    space = new TrieNode();
                space.add(str, index+1, count);
            }
        }

        public List<TrieNode> findMatching() {
            List<TrieNode> res = new ArrayList<>();
            if (this.str != null) res.add(this);
            for (int i = 0; i < 26; i++) {
                if (children[i] != null) {
                    res.addAll(children[i].findMatching());
                }
            }
            if (space != null) res.addAll(space.findMatching());
            return res;
        }
    }

    private TrieNode root, curr;
    private Map<String, Integer> history;
    private String cache;

    public AutocompleteSystem(String[] sentences, int[] times) {
        this.root = new TrieNode();
        this.curr = root;
        this.history = new HashMap<>();
        for (int i = 0; i < sentences.length; i++) {
            this.root.add(sentences[i], 0, times[i]);
            this.history.put(sentences[i], times[i]);
        }
        this.cache = "";
    }
    
    public List<String> input(char c) {
        if (c == '#') {
            List<String> res = new ArrayList<>();
            // if (curr != null) res = findTop(curr.findMatching());

            root.add(cache, 0, history.getOrDefault(cache, 0)+1);
            history.put(cache, history.getOrDefault(cache, 0)+1);

            curr = root;
            cache = "";
            return res;
        }

        cache += c;
        // System.out.println(cache);

        if (c == ' ' && curr != null && curr.space != null) {
            curr = curr.space;
            return findTop(curr.findMatching());
        } else if (c != ' ' && curr != null && curr.children[c - 'a'] != null) {
            curr = curr.children[c - 'a'];
            return findTop(curr.findMatching());
        } else {
            curr = null;
        }

        return new ArrayList<>();
    }

    private List<String> findTop(List<TrieNode> matches) {
        List<String> res = new ArrayList<>();
        Collections.sort(matches, (a, b) -> {
            if (a.count != b.count) return b.count - a.count;
            return a.str.compareTo(b.str);
        });
        for (int i = 0; i < 3 && i < matches.size(); i++) {
            res.add(matches.get(i).str);
        }
        return res;
    }
}

/**
 * Your AutocompleteSystem object will be instantiated and called as such:
 * AutocompleteSystem obj = new AutocompleteSystem(sentences, times);
 * List<String> param_1 = obj.input(c);
 */642