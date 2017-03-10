public class Solution {
    private List<String> res = null;

    public List<String> findItinerary(String[][] tickets) {
        Map<String, List<String>> neighbors = new HashMap<>();
        for (String[] t : tickets) {
            if (!neighbors.containsKey(t[0])) {
                neighbors.put(t[0], new ArrayList<>());
            }
            neighbors.get(t[0]).add(t[1]);
        }

        for (String key : neighbors.keySet()) {
            Collections.sort(neighbors.get(key));
        }

        List<String> res = new ArrayList<>();
        dfs("JFK", neighbors, res, tickets.length);
        return res;
    }

    private boolean dfs(String curr, Map<String, List<String>> neighbors, List<String> buffer, int rest) {
        buffer.add(curr);
        if (rest == 0) {
            res = new ArrayList<>(buffer);
            return true;
        }
        if (!neighbors.containsKey(curr)) {
            buffer.remove(buffer.size() - 1);
            return false;
        }
        List<String> next = neighbors.get(curr);
        if (next.isEmpty()) {
            buffer.remove(buffer.size() - 1);            
            return false;
        }

        for (int i = 0; i < next.size(); i++) {
            String des = next.get(i);
            next.remove(i);
            if (dfs(des, neighbors, buffer, rest - 1)) return true;
            next.add(i, des);
        }

        return false;
    }
}