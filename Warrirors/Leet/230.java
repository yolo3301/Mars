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
    public int kthSmallest(TreeNode root, int k) {
        Stack<TreeNode> s = new Stack<>();
        TreeNode p = root;
        int i = 1;

        while (p != null) {
            while (p != null) {
                s.push(p);
                p = p.left;
            }

            while (s.peek() != null && s.peek().right == null) {
                p = s.pop();
                if (i == k) {
                    return p.val;
                } else {
                    i++;
                }
            }

            if (s.empty()) {
                p = null;
            } else {
                p = s.pop();
                if (i == k) {
                    return p.val;
                } else {
                    i++;
                }
                p = p.right;
            }
        }

        return -1;
    }
}


// Follow up: What if the BST is modified (insert/delete operations) often and you need to find the kth smallest frequently? How would you optimize the kthSmallest routine?
// Keep a number of nodes in each node, and use that find the kth.
