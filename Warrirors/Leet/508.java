/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    private int maxFreq = 0, cnt = 0;
    private Map<Integer, Integer> map = new HashMap<>();
    private int[] res;
    public int[] findFrequentTreeSum(TreeNode root) {
        traverse(root);
        res = new int[cnt];
        int index = 0;

        for (Map.Entry<Integer, Integer> e : map.entrySet()) {
            if (e.getValue() == maxFreq) res[index++] = e.getKey();
        }

        return res;
    }

    private int traverse(TreeNode node) {
        if (node == null) return 0;

        int curr = node.val + traverse(node.left) + traverse(node.right);
        if (map.containsKey(curr)) {
            map.put(curr, map.get(curr) + 1);
        } else {
            map.put(curr, 1);
        }
        
        if (map.get(curr) > maxFreq) {
            cnt = 1;
            maxFreq = map.get(curr);
        } else if (map.get(curr) == maxFreq) {
            cnt++;
        }

        return curr;
    }
}