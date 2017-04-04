public class LFUCache {

    public class Node {
        public Node prev, next;
        public int freq;
        public LinkedHashSet<Integer> keys;
        public Node(int f) {
            freq = f;
            keys = new LinkedHashSet<>();
        }
    }

    private Node head, tail;
    private Map<Integer, Integer> vals;
    private Map<Integer, Node> nodes;
    private int cap;

    public LFUCache(int capacity) {
        cap = capacity;
        vals = new HashMap<>();
        nodes = new HashMap<>();
        head = new Node(0);
        tail = new Node(0);
        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int key) {
        if (!vals.containsKey(key)) return -1;

        int res = vals.get(key);
        Node n = nodes.get(key);
        increaseFreq(n, key);
        
        return res;
    }
    
    public void put(int key, int value) {
        if (cap == 0) return;
        if (vals.containsKey(key)) {
            vals.put(key, value);
            Node n = nodes.get(key);
            increaseFreq(n, key);
        } else {
            if (cap == vals.size()) {
                removeLeastFreq();
            }
            vals.put(key, value);
            increaseFreq(head, key);
        }
    }

    private void removeLeastFreq() {
        Node first = head.next;
        if (first != tail) {
            int r = first.keys.iterator().next();
            first.keys.remove(r);
            vals.remove(r);
            nodes.remove(r);

            if (first.keys.isEmpty()) {
                removeNode(first);
            }
        }
    }

    private void increaseFreq(Node curr, int key) {
        curr.keys.remove(key);
        if (curr.next.freq == curr.freq+1) {
            curr.next.keys.add(key);
            nodes.put(key, curr.next);
        } else {
            Node n = new Node(curr.freq+1);
            n.next = curr.next;
            n.prev = curr;
            curr.next = n;
            n.next.prev = n;
            n.keys.add(key);
            nodes.put(key, n);
        }

        if (curr != head && curr.keys.isEmpty()) {
            removeNode(curr);
        }
    }

    private void removeNode(Node target) {
        target.prev.next = target.next;
        target.next.prev = target.prev;
    }
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */