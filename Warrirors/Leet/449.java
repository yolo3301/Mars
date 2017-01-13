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
        StringBuilder sb = new StringBuilder();
        preOrder(root, sb);
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data.isEmpty()) return null;
        String[] vals = data.split(";");
        index = 0;
        return construct(vals, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private int index;

    private TreeNode construct(String[] vals, int min, int max) {
        if (index >= vals.length) return null;
        int curr = Integer.valueOf(vals[index]);

        if (curr >= min && curr <= max) {
            TreeNode node = new TreeNode(curr);
            index++;
            node.left = construct(vals, min, curr);
            node.right = construct(vals, curr, max);
            return node;
        }

        return null;
    }

    private void preOrder(TreeNode node, StringBuilder sb) {
        if (node == null) return;

        if (sb.length() > 0) sb.append(';');
        sb.append(node.val);

        preOrder(node.left, sb);
        preOrder(node.right, sb);
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));
