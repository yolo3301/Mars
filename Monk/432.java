public class AllOne {

    public class Node {
        public Node next;
        public Node prev;
        public int val;
        public Set<String> keys;
        public Node() {
            val = 0;
            keys = new HashSet<>();
        }
    }

    private Node head, tail;
    private Map<String, Node> map;

    /** Initialize your data structure here. */
    public AllOne() {
        head = new Node();
        tail = new Node();
        head.next = tail;
        tail.prev = head;
        map = new HashMap<>();
    }
    
    /** Inserts a new key <Key> with value 1. Or increments an existing key by 1. */
    public void inc(String key) {
        if (map.containsKey(key)) {
            Node p = map.get(key);
            if (p.next != tail && p.next.val == p.val + 1) {
                p.keys.remove(key);
                p.next.keys.add(key);
                map.put(key, p.next);
            } else {
                p.keys.remove(key);
                Node q = new Node();
                q.val = p.val + 1;
                q.keys.add(key);
                q.prev = p;
                q.next = p.next;
                p.next = q;
                q.next.prev = q;
                map.put(key, q);
            }
            
            if (p.keys.isEmpty()) {
                p.prev.next = p.next;
                p.next.prev = p.prev;
            }
        } else {
            if (head.next != tail && head.next.val == 1) {
                head.next.keys.add(key);
                map.put(key, head.next);
            } else {
                Node p = new Node();
                p.val = 1;
                p.keys.add(key);
                p.prev = head;
                p.next = head.next;
                head.next = p;
                p.next.prev = p;
                map.put(key, p);
            }
        }
    }
    
    /** Decrements an existing key by 1. If Key's value is 1, remove it from the data structure. */
    public void dec(String key) {
        if (!map.containsKey(key)) return;
        Node p = map.get(key);
        p.keys.remove(key);

        if (p.prev != head && p.prev.val == p.val - 1) {
            p.prev.keys.add(key);
            map.put(key, p.prev);
        } else {
            if (p.val == 1) {
                map.remove(key);
            } else {
                Node q = new Node();
                q.val = p.val - 1;
                q.keys.add(key);
                q.next = p;
                q.prev = p.prev;
                p.prev = q;
                q.prev.next = q;
                map.put(key, q);
            }
        }

        if (p.keys.size() == 0) {
            p.prev.next = p.next;
            p.next.prev = p.prev;
        }
    }
    
    /** Returns one of the keys with maximal value. */
    public String getMaxKey() {
        if (map.size() == 0) return "";
        return tail.prev.keys.iterator().next();
    }
    
    /** Returns one of the keys with Minimal value. */
    public String getMinKey() {
        if (map.size() == 0) return "";
        return head.next.keys.iterator().next();
    }
}

/**
 * Your AllOne object will be instantiated and called as such:
 * AllOne obj = new AllOne();
 * obj.inc(key);
 * obj.dec(key);
 * String param_3 = obj.getMaxKey();
 * String param_4 = obj.getMinKey();
 */