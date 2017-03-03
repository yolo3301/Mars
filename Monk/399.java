public class Solution {
    public double[] calcEquation(String[][] equations, double[] values, String[][] queries) {
        Map<String, Double> vals = new HashMap<>();
        Map<String, Set<String>> neighbors = new HashMap<>();
        Set<String> appear = new HashSet<>();
        double[] res = new double[queries.length];

        for (int i = 0; i < equations.length; i++) {
            String a = equations[i][0];
            String b = equations[i][1];

            vals.put(a + ";" + b, values[i]);
            vals.put(b + ";" + a, 1.0 / values[i]);

            if (!neighbors.containsKey(a)) {
                neighbors.put(a, new HashSet<>());
            }
            neighbors.get(a).add(b);

            if (!neighbors.containsKey(b)) {
                neighbors.put(b, new HashSet<>());
            }
            neighbors.get(b).add(a);

            appear.add(a);
            appear.add(b);
        }

        for (int i = 0; i < queries.length; i++) {
            String a = queries[i][0];
            String b = queries[i][1];
            if (vals.containsKey(a + ";" + b)) {
                res[i] = vals.get(a + ";" + b);
            } else if (!appear.contains(a) || !appear.contains(b)) {
                res[i] = -1.0;
            } else if (a.equals(b)) {
                res[i] = 1.0;
            } else {
                res[i] = search(a, b, vals, neighbors);
            }
        }

        return res;
    }

    private double search(String s, String e, Map<String, Double> vals, Map<String, Set<String>> neighbors) {
        Queue<String> nq = new LinkedList<>();
        Queue<Double> vq = new LinkedList<>();
        Set<String> seen = new HashSet<>();
        nq.add(s);
        vq.add(1.0);
        seen.add(s);

        while (!nq.isEmpty()) {
            String curr = nq.remove();
            double v = vq.remove();
            for (String n : neighbors.get(curr)) {
                if (!seen.contains(n)) {
                    seen.add(n);
                    double nv = v * vals.get(curr + ";" + n);
                    if (n.equals(e)) {
                        return nv;
                    } else {
                        nq.add(n);
                        vq.add(nv);
                    }
                }
            }
        }

        return -1.0;
    }
}