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
        if (root == null) return "#";
        return root.val + "," + serialize(root.left) + "," + serialize(root.right);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        index = 0;
        String[] elems = data.split(",");
        return deserialize(elems);
    }

    int index;
    private TreeNode deserialize(String[] elems) {
        String cur = elems[index++];
        if (cur.equals("#")) return null;
        TreeNode curNode = new TreeNode(Integer.valueOf(cur));
        curNode.left = deserialize(elems);
        curNode.right = deserialize(elems);

        return curNode;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));