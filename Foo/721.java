class Solution {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        Map<String, Set<String>> emailGraph = new HashMap<>();
        Map<String, String> emailToName = new HashMap<>();

        for (List<String> acc : accounts) {
            String name = acc.get(0);
            for (int i = 1; i < acc.size(); i++) {
                emailToName.put(acc.get(i), name);
                emailGraph.computeIfAbsent(acc.get(i), x -> new HashSet<>()).add(acc.get(1));
                emailGraph.computeIfAbsent(acc.get(1), x -> new HashSet<>()).add(acc.get(i));
            }
        }

        Set<String> seen = new HashSet<>();
        List<List<String>> ret = new ArrayList<>();

        for (String email : emailToName.keySet()) {
            if (seen.contains(email)) continue;

            // BFS
            List<String> curEmails = new ArrayList<>();
            Queue<String> q = new LinkedList<>();
            q.add(email);
            seen.add(email);
            curEmails.add(email);

            while (!q.isEmpty()) {
                String cur = q.remove();
                for (String next : emailGraph.get(cur)) {
                    if (!seen.contains(next)) {
                        q.add(next);
                        seen.add(next);
                        curEmails.add(next);
                    }
                }
            }

            Collections.sort(curEmails);
            curEmails.add(0, emailToName.get(email));
            ret.add(curEmails);
        }

        return ret;
    }
}
