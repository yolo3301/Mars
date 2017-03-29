/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) return "";
        StringBuilder sb = new StringBuilder();
        preOrder(root, sb);
        return sb.toString();
    }

    private int index;

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data.length() == 0) return null;
        index = 0;
        String[] vals = data.split(";");
        return construct(vals, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private TreeNode construct(String[] vals, int min, int max) {
        if (index >= vals.length) return null;

        int val = Integer.parseInt(vals[index]);

        if (min <= val && val <= max) {
            index++;
            TreeNode node = new TreeNode(val);
            node.left = construct(vals, min, val);
            node.right = construct(vals, val, max);
            return node;
        }

        return null;
    }

    private void preOrder(TreeNode node, StringBuilder sb) {
        if (node == null) return;

        if (sb.length() > 0) {
            sb.append(';');
        }
        sb.append(node.val);

        preOrder(node.left, sb);
        preOrder(node.right, sb);
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));