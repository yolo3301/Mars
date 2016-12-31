/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (head == null) return null;
        if (m == n) return head;

        int i = 1;
        ListNode p = head;
        ListNode fake = new ListNode(0);
        fake.next = head;
        ListNode last = fake;
        while (i < m) {
            last = p;
            p = p.next;
            i++;
        }

        ListNode[] r = reverse(p, m, n);
        last.next = r[0];

        return fake.next;
    }

    private ListNode[] reverse(ListNode node, int m, int n) {
        if (m == n) {
            ListNode[] res = new ListNode[2];
            res[0] = node;
            res[1] = node.next;
            return res;
        }

        ListNode[] heads = reverse(node.next, m + 1, n);
        node.next.next = node;
        node.next = heads[1];

        return heads;
    }
}
