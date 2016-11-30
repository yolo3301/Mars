/**
 * Definition for undirected graph.
 * class UndirectedGraphNode {
 *     int label;
 *     List<UndirectedGraphNode> neighbors;
 *     UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
 * };
 */
public class Solution {
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        return cloneBFS(node, new HashMap<>());
    }

    private UndirectedGraphNode cloneBFS(UndirectedGraphNode node, Map<Integer, UndirectedGraphNode> visited) {
        if (node == null) return null;

        Queue<UndirectedGraphNode> queue = new LinkedList<>();
        queue.add(node);

        UndirectedGraphNode copy = new UndirectedGraphNode(node.label);
        visited.put(node.label, copy);

        while (!queue.isEmpty()) {
            UndirectedGraphNode curr = queue.remove();
            for (UndirectedGraphNode n : curr.neighbors) {
                if (!visited.containsKey(n.label)) {
                    UndirectedGraphNode cn = new UndirectedGraphNode(n.label);
                    visited.put(cn.label, cn);
                    queue.add(n);
                }
                visited.get(curr.label).neighbors.add(visited.get(n.label));
            }
        }

        return copy;
    }
}
