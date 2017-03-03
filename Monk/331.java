public class Solution {
    private int index = 0;
    public boolean isValidSerialization(String preorder) {
        if (preorder.equals("#")) return true;

        String[] nodes = preorder.split(",");
        helper(nodes);

        return (index == nodes.length);
    }

    private void helper(String[] nodes) {
        if (index >= nodes.length || index < 0) {
            index = -1;
            return;
        }
        String curr = nodes[index++];

        if (curr.equals("#")) return;

        helper(nodes);
        helper(nodes);
    }
}