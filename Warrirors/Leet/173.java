/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

public class BSTIterator {

    private Stack<TreeNode> s;
    private TreeNode curr = null;

    public BSTIterator(TreeNode root) {
        s = new Stack<>();
        curr = root;
        cal();
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !s.empty();
    }

    /** @return the next smallest number */
    public int next() {
        curr = s.pop();
        int res = curr.val;
        if (curr.right != null) {
            curr = curr.right;
            cal();
        }
        return res;
    }

    private void cal() {
        while (curr != null) {
            s.push(curr);
            curr = curr.left;
        }
    }
}

/**
 * Your BSTIterator will be called like this:
 * BSTIterator i = new BSTIterator(root);
 * while (i.hasNext()) v[f()] = i.next();
 */
