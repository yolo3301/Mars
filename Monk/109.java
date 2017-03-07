/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
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
    private ListNode q;
    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) return null;

        int size = 0;
        ListNode p = head;
        q = head;
        while (p != null) {
            size++;
            p = p.next;
        }

        return helper(0, size - 1);
    }

    private TreeNode helper(int s, int e) {
        if (q == null || s > e) return null;

        int m = s + (e - s) / 2;
        TreeNode l = helper(s, m - 1);
        TreeNode curr = new TreeNode(q.val);
        q = q.next;
        TreeNode r = helper(m + 1, e);

        curr.left = l;
        curr.right = r;

        return curr;
    }
}