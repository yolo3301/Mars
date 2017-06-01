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
    public List<Integer> closestKValues(TreeNode root, double target, int k) {
        List<Integer> res = new ArrayList<>();

        Integer ex = findExact(root, target);
        if (ex != null) res.add(ex);

        Integer left = findPre(root, target);
        Integer right = findSuc(root, target);
        // System.out.println("l: " + left + "  r:" + right);
        while (res.size() < k) {
            if (right == null) {
                res.add(left);
                left = findPre(root, left);
            } else if (left == null) {
                res.add(right);
                right = findSuc(root, right);
            } else if (target - left < right - target) {
                res.add(left);
                left = findPre(root, left);
            } else {
                res.add(right);
                right = findSuc(root, right);
            }
            // System.out.println("l: " + left + "  r:" + right);
            // System.out.println(res);
        }

        return res;
    }

    private Integer findExact(TreeNode node, double target) {
        if (node == null) return null;
        if (node.val == target) return node.val;
        Integer res;
        if ((res = findExact(node.left, target)) != null) return res;
        if ((res = findExact(node.right, target)) != null) return res;
        return null;
    }

    private Integer findPre(TreeNode node, double target) {
        if (node == null) return null;
        if (node.val >= target) {
            return findPre(node.left, target);
        } else {
            TreeNode p = node.right;
            while (p != null && p.left != null) p = p.left;
            if (p == null || p.val >= target) return node.val;

            return findPre(node.right, target);
        }
    }

    private Integer findSuc(TreeNode node, double target) {
        if (node == null) return null;
        if (node.val <= target) {
            return findSuc(node.right, target);
        } else {
            TreeNode p = node.left;
            while (p != null && p.right != null) p = p.right;
            if (p == null || p.val <= target) return node.val;

            return findSuc(node.left, target);
        }
    }
}