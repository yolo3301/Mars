/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode[] splitListToParts(ListNode root, int k) {
        ListNode[] ret = new ListNode[k];
        int size = 0;
        ListNode p = root;
        while (p != null) {
            size++;
            p = p.next;
        }

        int base = size / k;
        int mod = size % k;

        ListNode p = root;
        int index = 0;

        while (p != null) {
            int cur = base + (mod > 0 ? 1 : 0);
            mod--;

            ListNode h = p, q = p, last = null;
            int cnt = 0;

            while (q != null && cnt < cur) {
                cnt++;
                last = q;
                q = q.next;
            }

            last.next = null;
            p = q;

            ret[index++] = h;
        }

        return ret;
    }
}