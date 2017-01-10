public class Solution {
    public List<List<String>> findLadders(String beginWord, String endWord, Set<String> wordList) {
        List<List<String>> res = new ArrayList<>();
        Set<String> used = new HashSet<>();
        used.add(beginWord);
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(beginWord, null));
        boolean found = false;

        while (!q.isEmpty() && !found) {
            int size = q.size();
            for (int j = 0; j < size; j++) {
                Node curr = q.remove();
                //System.out.println("curr word: " + curr.word);
                if (curr.word.equals(endWord)) {
                    found = true;
                    res.add(getList(curr));
                } else if (!found) {
                    used.add(curr.word);
                    char[] w = curr.word.toCharArray();
                    for (int i = 0; i < w.length; i++) {
                        char temp = w[i];
                        for (char c = 'a'; c <= 'z'; c++) {
                            if (c != temp) {
                                w[i] = c;
                                String next = new String(w);
                                if (!used.contains(next) && wordList.contains(next))
                                    q.add(new Node(next, curr));
                                w[i] = temp;
                            }
                        }
                    }
                }
            }
        }

        return res;
    }

    private List<String> getList(Node n) {
        ArrayList<String> res = new ArrayList<>();
        Node p = n;
        while (p != null) {
            res.add(0, p.word);
            p = p.prev;
        }
        // Collections.reverse(res);
        return res;
    }

    public class Node {
        public String word;
        public Node prev;
        public Node(String w, Node p) {
            word = w;
            prev = p;
        }
    }
}
