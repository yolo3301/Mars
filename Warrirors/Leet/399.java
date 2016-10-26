public class Solution {
    public double[] calcEquation(String[][] equations, double[] values, String[][] queries) {
        Map<String, Double> valMap = new HashMap<>();
        Set<String> appear = new HashSet<>();
        Map<String, Set<String>> next = new HashMap<>();
        double[] res = new double[queries.length];

        for (int i = 0; i < equations.length; i++) {
            valMap.put(equations[i][0] + ";" + equations[i][1], values[i]);
            valMap.put(equations[i][1] + ";" + equations[i][0], 1 / values[i]);
            appear.add(equations[i][0]);
            appear.add(equations[i][1]);

            if (!next.containsKey(equations[i][0])) {
                next.put(equations[i][0], new HashSet<String>());
            }
            next.get(equations[i][0]).add(equations[i][1]);

            if (!next.containsKey(equations[i][1])) {
                next.put(equations[i][1], new HashSet<String>());
            }
            next.get(equations[i][1]).add(equations[i][0]);
        }

        for (int i = 0; i < queries.length; i++) {
            String a = queries[i][0];
            String b = queries[i][1];
            if (!appear.contains(a) || !appear.contains(b)) {
                res[i] = -1.0;
            } else if (valMap.containsKey(a + ";" + b)) {
                res[i] = valMap.get(a + ";" + b);
            } else if (a.equals(b)) {
                res[i] = 1.0;
            } else {
                res[i] = search(a, b, valMap, next);
            }
        }

        return res;
    }

    private double search(String a, String b, Map<String, Double> valMap, Map<String, Set<String>> next) {
        Queue<String> q = new LinkedList<>();
        Queue<Double> vals = new LinkedList<>();
        Set<String> seen = new HashSet<>();
        q.add(a);
        vals.add(1.0);

        while (q.peek() != null) {
            String curr = q.remove();
            double val = vals.remove();
            for (String n : next.get(curr)) {
                double tmp = val * valMap.get(curr + ";" + n);
                if (!valMap.containsKey(a + ";" + n)) {
                    valMap.put(a + ";" + n, tmp);
                }
                if (!seen.contains(n)) {
                    seen.add(n);
                    q.add(n);
                    vals.add(tmp);
                }
                if (n.equals(b)) {
                    return tmp;
                }
            }
        }

        return -1.0;
    }
}
