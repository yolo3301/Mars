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

    private Stack<TreeNode> stack;

    public BSTIterator(TreeNode root) {
        this.stack = new Stack<>();
        this.pushStack(root);
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !this.stack.empty();
    }

    /** @return the next smallest number */
    public int next() {
        TreeNode ret = stack.pop();
        this.pushStack(ret.right);
        return ret.val;
    }

    private void pushStack(TreeNode node) {
        while (node != null) {
            this.stack.push(node);
            node = node.left;
        }
    }
}

/**
 * Your BSTIterator will be called like this:
 * BSTIterator i = new BSTIterator(root);
 * while (i.hasNext()) v[f()] = i.next();
 */

