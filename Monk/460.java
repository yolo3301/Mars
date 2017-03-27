public class LFUCache {

    public class Node {
        public Node prev;
        public Node next;
        public LinkedHashSet<Integer> keys;
        public int freq;
        public Node() {
            keys = new LinkedHashSet<>();
            freq = 0;
        }
    }

    private Map<Integer, Integer> values;
    private Map<Integer, Node> nodes;
    private Node head, tail;
    private int cap;

    public LFUCache(int capacity) {
        this.cap = capacity;
        this.values = new HashMap<>();
        this.nodes = new HashMap<>();
        this.head = new Node();
        this.tail = new Node();
        this.head.next = tail;
        this.tail.prev = head;
    }
    
    public int get(int key) {
        if (!values.containsKey(key)) return -1;
        increaseFreq(key);
        return values.get(key);
    }
    
    public void put(int key, int value) {
        if (cap <= 0) return;
        
        if (!values.containsKey(key) && values.size() == cap) {
            removeLeastFreq();
        }

        values.put(key, value);
        increaseFreq(key);
    }

    private void increaseFreq(int key) {
        if (nodes.containsKey(key)) {
            appendAfter(nodes.get(key), key);
        } else {
            appendAfter(head, key);
        }
    }

    private void appendAfter(Node curr, int key) {
        if (curr.next == tail || curr.next.freq != curr.freq + 1) {
            Node n = new Node();
            n.freq = curr.freq + 1;
            n.next = curr.next;
            n.prev = curr;
            curr.next = n;
            n.next.prev = n;
        }
        curr.keys.remove(key);
        curr.next.keys.add(key);
        nodes.put(key, curr.next);

        if (curr.keys.isEmpty() && curr != head && curr != tail) {
            removeNode(curr);
        }
    }

    private void removeLeastFreq() {
        if (head.next != tail) {
            int toRemove = head.next.keys.iterator().next();
            head.next.keys.remove(toRemove);
            nodes.remove(toRemove);
            values.remove(toRemove);

            if (head.next.keys.isEmpty()) {
                removeNode(head.next);
            }
        }
    }

    private void removeNode(Node curr) {
        curr.prev.next = curr.next;
        curr.next.prev = curr.prev;
    }
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */