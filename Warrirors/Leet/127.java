public class Solution {
    public int ladderLength(String beginWord, String endWord, Set<String> wordList) {
        Queue<String> q = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        int level = 1;
        q.add(beginWord);
        visited.add(beginWord);

        while (!q.isEmpty()) {
            int size = q.size();
            for (int k = 0; k < size; k++) {
                String curr = q.remove();
                if (curr.equals(endWord)) return level;
                char[] chs = curr.toCharArray();
                for (int i = 0; i < chs.length; i++) {
                    for (int j = 0; j < 26; j++) {
                        if (chs[i] != (char)('a' + j)) {
                            char o = chs[i];
                            chs[i] = (char)('a' + j);
                            String next = new String(chs);
                            if (!visited.contains(next) && wordList.contains(next)) {
                                visited.add(next);
                                q.add(next);
                            }
                            chs[i] = o;
                        }
                    }
                }
            }
            level++;
        }

        return 0;
    }
}
