class Solution {
    public List<String> findWords(char[][] board, String[] words) {
        List<String> ret = new ArrayList<>();
        if (words.length == 0) return ret;
        int m = board.length;
        if (m == 0) return ret;
        int n = board[0].length;
        if (n == 0) return ret;

        TrieNode root = new TrieNode();
        for (String w : words) root.add(w, 0);
        boolean[][] visited = new boolean[m][n];
        Set<String> set = new HashSet<>();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                tryFind(i, j, board, "", root, set);
            }
        }

        return new ArrayList<>(set);
    }

    private void tryFind(int x, int y, char[][] board, String buffer, TrieNode node, Set<String> ret) {
        if (node != null && node.isEnd) ret.add(buffer);
        if (x < 0 || x >= board.length || y < 0 || y >= board[0].length || board[x][y] == '.') return;

        char cur = board[x][y];
        TrieNode next = node.children[cur - 'a'];
        if (next == null) return;

        board[x][y] = '.';
        String buf = buffer + cur;

        tryFind(x+1, y, board, buf, next, ret);
        tryFind(x-1, y, board, buf, next, ret);
        tryFind(x, y+1, board, buf, next, ret);
        tryFind(x, y-1, board, buf, next, ret);
        
        board[x][y] = cur;
    }

    class TrieNode {
        public boolean isEnd;
        public TrieNode[] children;
        public TrieNode() {
            isEnd = false;
            children = new TrieNode[26];
        }

        public void add(String str, int index) {
            if (index == str.length()) {
                isEnd = true;
                return;
            }

            char ch = str.charAt(index);
            if (children[ch - 'a'] == null) children[ch - 'a'] = new TrieNode();

            children[ch - 'a'].add(str, index+1);
        }
    }
}