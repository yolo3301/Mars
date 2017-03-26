public class Solution {
    public List<String> findWords(char[][] board, String[] words) {
        if (words.length == 0) return new ArrayList<>();
        int m = board.length;
        if (m == 0) return new ArrayList<>();
        int n = board[0].length;
        if (n == 0) return new ArrayList<>();

        Trie trie = new Trie();
        for (String w : words) trie.add(w);
        Set<String> res = new HashSet<>();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                helper(new int[]{i, j}, board, trie.root, "", res);
            }
        }

        return new ArrayList<String>(res);
    }

    private void helper(int[] pos, char[][] board, Trie.TrieNode node, String buffer, Set<String> res) {
        if (node.isEnd) res.add(buffer);
        if (pos[0] < 0 || pos[0] >= board.length || pos[1] < 0 || pos[1] >= board[0].length
            || board[pos[0]][pos[1]] == '*') return;
        
        char curr = board[pos[0]][pos[1]];
        if (node.children[curr - 'a'] == null) return;

        board[pos[0]][pos[1]] = '*';
        Trie.TrieNode next = node.children[curr - 'a'];

        helper(new int[]{pos[0]-1, pos[1]}, board, next, buffer + curr, res);
        helper(new int[]{pos[0]+1, pos[1]}, board, next, buffer + curr, res);
        helper(new int[]{pos[0], pos[1]-1}, board, next, buffer + curr, res);
        helper(new int[]{pos[0], pos[1]+1}, board, next, buffer + curr, res);

        board[pos[0]][pos[1]] = curr;
    }

    public class Trie {
        public class TrieNode {
            public TrieNode[] children;
            public boolean isEnd;
            public TrieNode() {
                this.children = new TrieNode[26];
            }
        }

        public TrieNode root;

        public Trie() {
            this.root = new TrieNode();
        }

        public void add(String w) {
            TrieNode p = root;
            for (char ch : w.toCharArray()) {
                if (p.children[ch - 'a'] == null) {
                    p.children[ch - 'a'] = new TrieNode();
                }
                p = p.children[ch - 'a'];
            }

            p.isEnd = true;
        }
    }
}