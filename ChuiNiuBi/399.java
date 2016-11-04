/*
399. Evaluate Division

Equations are given in the format A / B = k, where A and B are variables represented as strings, and k is a real number (floating point number). Given some queries, return the answers. If the answer does not exist, return -1.0.

Example:
Given a / b = 2.0, b / c = 3.0. 
queries are: a / c = ?, b / a = ?, a / e = ?, a / a = ?, x / x = ? . 
return [6.0, 0.5, -1.0, 1.0, -1.0 ].

The input is: vector<pair<string, string>> equations, vector<double>& values, vector<pair<string, string>> queries , where equations.size() == values.size(), and the values are positive. This represents the equations. Return vector<double>.

According to the example above:

equations = [ ["a", "b"], ["b", "c"] ],
values = [2.0, 3.0],
queries = [ ["a", "c"], ["b", "a"], ["a", "e"], ["a", "a"], ["x", "x"] ]. 
The input is always valid. You may assume that evaluating the queries will result in no division by zero and there is no contradiction.
*/

public class Solution {
    public double[] calcEquation(String[][] equations, double[] values, String[][] queries) {
        Map<String, Integer> matrix = new HashMap<String, Integer>();
        int len = 0;
        for (String[] eq : equations) {
            for (String e : eq) {
                if (!matrix.containsKey(e))
                    matrix.put(e, len++);
            }
        }
        
        double[][] ans = new double[len][len];
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                ans[i][j] = (i == j) ? 1.0d : -1.0d;
            }
        }
        
        for (int i = 0; i < equations.length; i++) {
            String[] eq = equations[i];
            int row = matrix.get(eq[0]);
            int col = matrix.get(eq[1]);
            ans[row][col] = values[i];
            ans[col][row] = 1 / values[i];
        }
        
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                for (int k = 0; k < len; k++) {
                    if (ans[i][j] >= 0d && ans[j][k] >= 0d && ans[i][k] == -1.0d) {
                        ans[i][k] = ans[i][j] * ans[j][k];
                        ans[k][i] = 1 / ans[i][k];
                    }
                }
            }
        }
        
        double[] results = new double[queries.length];
        for (int i = 0; i < queries.length; i++) {
            String[] q = queries[i];
            Integer row = matrix.get(q[0]);
            Integer col = matrix.get(q[1]);
            if (row == null || col == null)
                results[i] = -1.0d;
            else
                results[i] = ans[row][col];
        }
        
        return results;
    }
}