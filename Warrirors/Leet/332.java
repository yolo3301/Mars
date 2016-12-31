public class Solution {
    List<String> res = new ArrayList<>();
    public List<String> findItinerary(String[][] tickets) {
        Map<String, List<String>> dist = new HashMap<>();

        for (String[] trip : tickets) {
            if (!dist.containsKey(trip[0])) {
                dist.put(trip[0], new ArrayList<>());
            }
            dist.get(trip[0]).add(trip[1]);
        }

        for (String key : dist.keySet()) {
            Collections.sort(dist.get(key));
        }

        List<String> buffer = new ArrayList<>();
        if (tickets.length == 0) return res;

        buffer.add("JFK");
        dfs("JFK", dist, buffer, tickets.length);

        return res;
    }

    private boolean dfs(String curr, Map<String, List<String>> dist, List<String> buffer, int rest) {
        if (rest == 0) {
            res = new ArrayList<>(buffer);
            return true;
        }
        if ((!dist.containsKey(curr) || dist.get(curr).isEmpty()) && rest > 0) {
            return false;
        }

        boolean found = false;

        for (int i = 0; i < dist.get(curr).size(); i++) {
            String next = dist.get(curr).get(i);
            dist.get(curr).remove(i);
            buffer.add(next);
            found = dfs(next, dist, buffer, rest - 1);
            dist.get(curr).add(i, next);
            buffer.remove(buffer.size() - 1);
            if (found) break;
        }

        return found;
    }
}
