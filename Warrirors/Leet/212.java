public class Solution {
    public List<String> findWords(char[][] board, String[] words) {
        int m = board.length;
        if (m == 0) return new ArrayList<>();
        int n = board[0].length;
        if (n == 0) return new ArrayList<>();

        Trie trie = new Trie();
        for (String w : words) {
            if (!w.isEmpty()) trie.add(w);
        }

        Set<String> res = new HashSet<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++)
                explore(i, j, board, "", trie.root, res);
        }

        return new ArrayList<>(res);
    }

    private void explore(int x, int y, char[][] board, String sofar, TrieNode node, Set<String> res) {
        if (x >= board.length || y >= board[0].length || x < 0 || y < 0 || board[x][y] == '.' || node.tryGetNext(board[x][y]) == null) return;

        char curr = board[x][y];
        TrieNode p = node.tryGetNext(curr);
        board[x][y] = '.';
        String currStr = sofar + curr;
        
        if (p.isEnd) {
            res.add(currStr);
        }

        explore(x+1, y, board, currStr, p, res);
        explore(x-1, y, board, currStr, p, res);
        explore(x, y+1, board, currStr, p, res);
        explore(x, y-1, board, currStr, p, res);

        board[x][y] = curr;
    }

    public class TrieNode {
        public char curr;
        public TrieNode[] next;
        public boolean isEnd;

        public TrieNode(char ch) {
            curr = ch;
            next = new TrieNode[26];
        }

        public TrieNode getNext(char ch) {
            if (next[ch - 'a'] == null) {
                next[ch - 'a'] = new TrieNode(ch);
            }

            return next[ch - 'a'];
        }

        public TrieNode tryGetNext(char ch) {
            return next[ch - 'a'];
        }
    }

    public class Trie {
        public TrieNode root;

        public Trie() {
            root = new TrieNode('*');
        }

        public void add(String str) {
            TrieNode p = root;
            for (char ch : str.toCharArray()) {
                p = p.getNext(ch);
            }

            p.isEnd = true;
        }

        public boolean isWord(String str) {
            TrieNode p = root;
            for (char ch : str.toCharArray()) {
                p = p.tryGetNext(ch);
                if (p == null) return false;
            }

            return p.isEnd;
        }

        public boolean isPrefix(String str) {
            TrieNode p = root;
            for (char ch : str.toCharArray()) {
                p = p.tryGetNext(ch);
                if (p == null) return false;
            }

            return true;
        }
    }
}
