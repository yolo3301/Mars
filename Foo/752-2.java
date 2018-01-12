class Solution {
    public int openLock(String[] deadends, String target) {
        Set<String> visited = new HashSet<>();
        for (String d : deadends) visited.add(d);
        if (visited.contains("0000")) return -1;

        Queue<String> q = new LinkedList<>();
        q.add("0000");

        int step = 0;

        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                String cur = q.remove();

                if (target.equals(cur))
                    return step;

                char[] chs = cur.toCharArray();
                for (int j = 0; j < 4; j++) {
                    char tmp = chs[j];
                    chs[j] = (tmp == '0') ? '9' : (char)(tmp-1);

                    String next1 = new String(chs);
                    if (!visited.contains(next1)) {
                        q.add(next1);
                        visited.add(next1);
                    }

                    chs[j] = (tmp == '9') ? '0' : (char)(tmp+1);

                    String next2 = new String(chs);
                    if (!visited.contains(next2)) {
                        q.add(next2);
                        visited.add(next2);
                    }

                    chs[j] = tmp;
                }
            }

            step++;
        }

        return -1;
    }
}

