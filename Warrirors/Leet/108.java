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
    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums == null) return null;
        return build(0, nums.length - 1, nums);
    }

    private TreeNode build(int s, int e, int[] nums) {
        if (s > e) return null;

        int m = (s + e) / 2;
        TreeNode curr = new TreeNode(nums[m]);
        curr.left = build(s, m - 1);
        curr.right = build(m + 1, e);

        return curr;
    }
}
