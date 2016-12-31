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
        serialize(root, sb);
        return sb.toString();
    }

    private void serialize(TreeNode node, StringBuilder sb) {
        if (node == null) {
            sb.append("x,");
            return;
        }

        sb.append(node.val).append(',');
        serialize(node.left, sb);
        serialize(node.right, sb);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        List<String> parts = Arrays.asList(data.split(","));
        Iterator<String> iter = parts.iterator();
        return deserialize(iter);
    }

    private TreeNode deserialize(Iterator<String> iter) {
        if (!iter.hasNext()) return null;

        String curr = iter.next();
        if (curr == null || curr.equals("x")) return null;

        int val = Integer.valueOf(curr);
        TreeNode node = new TreeNode(val);
        node.left = deserialize(iter);
        node.right = deserialize(iter);

        return node;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));
