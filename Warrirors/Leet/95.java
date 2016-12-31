/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
 // can be improved with memo
public class Solution {
    public List<TreeNode> generateTrees(int n) {
        if (n == 0) return new ArrayList<TreeNode>();
        return generate(1, n);
    }

    private List<TreeNode> generate(int s, int e) {
        if (s > e) return null;
        // if (mem[s][e] != null) return mem[s][e];

        List<TreeNode> res = new ArrayList<>();
        if (s == e) {
            res.add(new TreeNode(s));
            // mem[s][e] = res;
            return res;
        }

        for (int i = s; i <= e; i++) {
            List<TreeNode> left = generate(s, i - 1);
            List<TreeNode> right = generate(i + 1, e);

            if (left == null) {
                for (TreeNode r : right) {
                    TreeNode curr = new TreeNode(i);
                    curr.right = r;
                    curr.left = null;
                    res.add(curr);
                }
            } else if (right == null) {
                for (TreeNode l : left) {
                    TreeNode curr = new TreeNode(i);
                    curr.left = l;
                    curr.right = null;
                    res.add(curr);
                }
            } else {
                for (TreeNode l : left) {
                    for (TreeNode r : right) {
                        TreeNode curr = new TreeNode(i);
                        curr.left = l;
                        curr.right = r;
                        res.add(curr);
                    }
                }
            }
        }

        // mem[s][e] = res;
        return res;
    }
}
