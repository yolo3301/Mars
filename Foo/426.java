/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;

    public Node() {}

    public Node(int _val,Node _left,Node _right) {
        val = _val;
        left = _left;
        right = _right;
    }
};
*/
class Solution {
    public Node treeToDoublyList(Node root) {
        Node[] n = helper(root);
        if (n == null) return null;
        n[0].left = n[1];
        n[1].right = n[0];
        return n[0];
    }

    private Node[] helper(Node node) {
        if (node == null) return null;
        Node[] left = helper(node.left);
        Node[] right = helper(node.right);

        Node h = node, t = node;
        if (left != null) {
            h = left[0];
            left[1].right = node;
            node.left = left[1];
        }
        if (right != null) {
            t = right[1];
            node.right = right[0];
            right[0].left = node;
        }
        return new Node[]{h, t};
    }
}