/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return helper(nums, 0, nums.length-1);
    }

    private TreeNode helper(int[] nums, int s, int e) {
        if (s > e) return null;
        if (s == e) return new TreeNode(nums[s]);

        int m = maxIndex(nums, s, e);
        TreeNode res = new TreeNode(nums[m]);
        res.left = helper(nums, s, m-1);
        res.right = helper(nums, m+1, e);
        return res;
    }

    private int maxIndex(int[] nums, int s, int e) {
        int m = s;
        for (int i = s+1; i <= e; i++) {
            if (nums[i] > nums[m])
                m = i;
        }
        return m;
    }
}