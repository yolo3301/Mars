/**
 * Definition for singly-linked list with a random pointer.
 * class RandomListNode {
 *     int label;
 *     RandomListNode next, random;
 *     RandomListNode(int x) { this.label = x; }
 * };
 */
public class Solution {
    public RandomListNode copyRandomList(RandomListNode head) {
        if (head == null) return null;

        RandomListNode p = head;
        while (p != null) {
            RandomListNode q = new RandomListNode(p.label);
            q.next = p.next;
            p.next = q;
            p = q.next;
        }

        p = head;
        while (p != null) {
            if (p.random != null) {
                p.next.random = p.random.next;
            }
            p = p.next.next;
        }

        p = head;
        RandomListNode res = p.next;
        while (p != null) {
            RandomListNode q = p.next;
            p.next = q.next;
            if (q.next != null) {
                q.next = q.next.next;
            }

            p = p.next;
        }

        return res;
    }
}
