public class Solution {
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        List<List<String>> res = new ArrayList<>();
        Set<String> dict = new HashSet<>(wordList);
        if (dict.isEmpty()) return res;
        if (endWord.equals(beginWord)) {
            res.add(Arrays.asList(beginWord));
            return res;
        }

        Queue<String> queue = new LinkedList<>();
        Map<String, List<String>> prev = new HashMap<>();
        Set<String> visited = new HashSet<>();
        boolean found = false;
        queue.add(beginWord);
        visited.add(beginWord);

        while (!queue.isEmpty()) {
            int size = queue.size();
            if (found) break;
            Set<String> currVisited = new HashSet<>();
            for (int j = 0; j < size; j++) {
                String curr = queue.remove();
                char[] chs = curr.toCharArray();

                for (int i = 0; i < chs.length; i++) {
                    for (char ch = 'a'; ch <= 'z'; ch++) {
                        char origin = chs[i];
                        if (ch != origin) {
                            chs[i] = ch;
                            String next = new String(chs);
                            if (next == endWord) {
                                if (!prev.containsKey(next))
                                    prev.put(next, new ArrayList<>());
                                prev.get(next).add(curr);
                                found = true;
                            } else if (dict.contains(next) && !visited.contains(next)) {
                                if (!prev.containsKey(next))
                                    prev.put(next, new ArrayList<>());
                                prev.get(next).add(curr);
                                if (currVisited.add(next)) queue.add(next);
                            }
                        }
                        chs[i] = origin;
                    }
                }
            }

            visited.addAll(currVisited);
        }

        // System.out.println(prev);
        if (prev.containsKey(endWord))
            bt(endWord, prev, new ArrayList<>(), res);

        return res;
    }

    private void bt(String word, Map<String, List<String>> prev, List<String> buffer, List<List<String>> res) {
        if (!prev.containsKey(word)) {
            buffer.add(word);
            List<String> tmp = new ArrayList<>(buffer);
            Collections.reverse(tmp);
            res.add(tmp);
            buffer.remove(buffer.size() - 1);
            return;
        }

        buffer.add(word);
        for (String next : prev.get(word)) {
            bt(next, prev, buffer, res);
        }
        buffer.remove(buffer.size() - 1);
    }
}