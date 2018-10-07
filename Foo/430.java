/*
// Definition for a Node.
class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;

    public Node() {}

    public Node(int _val,Node _prev,Node _next,Node _child) {
        val = _val;
        prev = _prev;
        next = _next;
        child = _child;
    }
};
*/
class Solution {
    public Node flatten(Node head) {
        helper(head);
        return head;
    }

    public Node helper(Node node) {
        Node p = node;
        while (p != null) {
            if (p.child != null) {
                Node last = helper(p.child);
                Node pn = p.next;
                p.next = p.child;
                p.child.prev = p;
                p.child = null;
                last.next = pn;
                if (pn != null) {
                    pn.prev = last;
                }
                p = last;
            }
            if (p.next != null) {
                p = p.next;
            } else {
                break;
            }
        }
        return p;
    }
}