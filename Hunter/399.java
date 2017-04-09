public class Solution {
    public double[] calcEquation(String[][] equations, double[] values, String[][] queries) {
        if (queries.length == 0) return new double[0];
        Map<String, Double> vals = new HashMap<>();
        Map<String, Set<String>> neighbors = new HashMap<>();

        for (int i = 0; i < equations.length; i++) {
            String a = equations[i][0];
            String b = equations[i][1];

            if (!neighbors.containsKey(a)) neighbors.put(a, new HashSet<>());
            if (!neighbors.containsKey(b)) neighbors.put(b, new HashSet<>());
            neighbors.get(a).add(b);
            neighbors.get(b).add(a);

            String comb1 = a + "/" + b;
            String comb2 = b + "/" + a;
            vals.put(comb1, values[i]);
            vals.put(comb2, 1.0 / values[i]);
        }

        double[] res = new double[queries.length];
        for (int i = 0; i < queries.length; i++) {
            String a = queries[i][0];
            String b = queries[i][1];
            if (!neighbors.containsKey(a) || !neighbors.containsKey(b)) res[i] = -1.0;
            else if (a.equals(b)) res[i] = 1.0;
            else if (vals.containsKey(a + "/" + b)) res[i] = vals.get(a + "/" + b);
            else res[i] = search(a, b, neighbors, vals);
        }

        return res;
    }

    private double search(String start, String end, Map<String, Set<String>> neighbors, Map<String, Double> values) {
        Queue<String> nq = new LinkedList<>();
        Queue<Double> vq = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        visited.add(start);
        nq.add(start);
        vq.add(1.0);

        while (!nq.isEmpty()) {
            String curr = nq.remove();
            double pv = vq.remove();

            if (neighbors.containsKey(curr)) {
                for (String next : neighbors.get(curr)) {
                    if (!visited.contains(next)) {
                        double nv = values.get(curr + "/" + next);
                        if (next.equals(end)) {
                            return nv * pv;
                        } else {
                            nq.add(next);
                            vq.add(nv * pv);
                        }
                    }
                }
            }
        }

        return -1.0;
    }
}