public class Solution {
    List<String> res = null;
    public List<String> findItinerary(String[][] tickets) {
        if (tickets.length == 0) return new ArrayList<>();
        Map<String, List<String>> dest = new HashMap<>();
        for (String[] e : tickets) {
            if (!dest.containsKey(e[0])) dest.put(e[0], new ArrayList<>());
            dest.get(e[0]).add(e[1]);
        }

        for (String k : dest.keySet()) {
            Collections.sort(dest.get(k));
        }

        List<String> buffer = new ArrayList<>();
        buffer.add("JFK");
        dfs("JFK", dest, buffer, tickets.length+1);
        return res;
    }

    private void dfs(String curr, Map<String, List<String>> dest, List<String> buffer, int total) {
        if (buffer.size() == total) {
            res = new ArrayList<>(buffer);
            return;
        }

        if (!dest.containsKey(curr)) return;
        int size = dest.get(curr).size();
        for (int i = 0; i < size; i++) {
            String d = dest.get(curr).get(i);
            dest.get(curr).remove(i);
            buffer.add(d);
            dfs(d, dest, buffer, total);
            buffer.remove(buffer.size() - 1);
            dest.get(curr).add(i, d);

            if (res != null) return;
        }
    }
}