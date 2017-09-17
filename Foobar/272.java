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
    public List<Integer> closestKValues(TreeNode root, double target, int k) {
        List<Integer> res = new ArrayList<>();
        Integer m = findExact(root, target);
        if (m != null) res.add(m);

        Integer l = findPre(root, target);
        Integer r = findSuc(root, target);

        while (res.size() < k) {
            if (l == null) {
                res.add(r);
                r = findSuc(root, (double)r.intValue());
            } else if (r == null) {
                res.add(l);
                l = findPre(root, (double)l.intValue());
            } else if (target - l <= r - target) {
                res.add(l);
                l = findPre(root, (double)l.intValue());
            } else {
                res.add(r);
                r = findSuc(root, (double)r.intValue());
            }
        }

        return res;
    }

    private Integer findExact(TreeNode node, double target) {
        if (node == null) return null;
        if (node.val == target) return node.val;

        if (node.val < target) return findExact(node.right, target);
        else return findExact(node.left, target);
    }

    private Integer findPre(TreeNode node, double target) {
        if (node == null) return null;
        if (node.val >= target) {
            return findPre(node.left, target);
        } else {
            Integer cand = findPre(node.right, target);
            if (cand == null) return node.val;
            return cand;
        }
    }

    private Integer findSuc(TreeNode node, double target) {
        if (node == null) return null;
        if (node.val <= target) {
            return findSuc(node.right, target);
        } else {
            Integer cand = findSuc(node.left, target);
            if (cand == null) return node.val;
            return cand;
        }
    }
}

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
    public List<Integer> closestKValues(TreeNode root, double target, int k) {
        List<Integer> res = new ArrayList<>();
        Stack<Integer> s1 = new Stack<>();
        Stack<Integer> s2 = new Stack<>();
        inorder(root, target, false, s1);
        inorder(root, target, true, s2);
        // System.out.println(s1 + " " + s2);
        while (res.size() < k) {
            if (s1.empty()) res.add(s2.pop());
            else if (s2.empty()) res.add(s1.pop());
            else if (target - s1.peek() <= s2.peek() - target) {
                res.add(s1.pop());
            } else {
                res.add(s2.pop());
            }
        }
        return res;
    }

    private void inorder(TreeNode node, double target, boolean reverse, Stack<Integer> stack) {
        if (node == null) return;

        inorder(reverse ? node.right : node.left, target, reverse, stack);
        if (reverse) {
            if (node.val <= target) return;
        } else {
            if (node.val > target) return;
        }
        stack.push(node.val);
        inorder(reverse ? node.left : node.right, target, reverse, stack);
    }
}