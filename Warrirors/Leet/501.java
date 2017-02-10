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
    private int curr = 0;
    private int cnt = 0;
    private int freq = 0;
    private int maxFreq = 0;
    private int[] modes = null;

    public int[] findMode(TreeNode root) {
        inOrder(root);
        modes = new int[cnt];
        cnt = 0;
        freq = 0;
        inOrder(root);

        return modes;
    }

    private void inOrder(TreeNode node) {
        if (node == null) return;
        inOrder(node.left);
        handleVal(node.val);
        inOrder(node.right);
    }

    private void handleVal(int val) {
        if (val != curr) {
            curr = val;
            freq = 0;
        }

        freq++;
        if (freq > maxFreq) {
            maxFreq = freq;
            cnt = 1;
        } else if (freq == maxFreq) {
            if (modes != null) {
                modes[cnt] = val;
            }
            cnt++;
        }
    }
}