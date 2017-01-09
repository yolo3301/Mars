public class LRUCache {
    private int cap;
    private Node head;
    private Node tail;
    private Map<Integer, Node> map;

    public LRUCache(int capacity) {
        head = null;
        tail = null;
        cap = capacity;
        map = new HashMap<>();
    }

    public int get(int key) {
        if (!map.containsKey(key)) return -1;
        Node n = map.get(key);
        removeNode(n);
        addToTail(n);
        return n.val;
    }

    public void set(int key, int value) {
        if (map.containsKey(key)) {
            map.get(key).val = value;
            get(key);
            return;
        }

        Node n = new Node(key, value);

        if (map.size() >= cap && head != null) {
            map.remove(head.key);
            removeNode(head);
        }
        addToTail(n);
        map.put(key, n);
    }

    private void removeNode(Node n) {
        if (n == head && n == tail) {
            head = null;
            tail = null;
        } else if (n == head) {
            head = n.next;
            head.prev = null;
        } else if (n == tail) {
            tail = n.prev;
            tail.next = null;
        } else {
            n.prev.next = n.next;
            n.next.prev = n.prev;
        }

        n.prev = null;
        n.next = null;
    }

    private void addToHead(Node n) {
        if (head == null) {
            head = n;
            tail = n;
        } else {
            n.next = head;
            head.prev = n;
            head = n;
        }
    }

    private void addToTail(Node n) {
        if (tail == null) {
            head = n;
            tail = n;
        } else {
            tail.next = n;
            n.prev = tail;
            tail = n;
        }
    }

    public class Node {
        public int key;
        public int val;
        public Node prev;
        public Node next;
        public Node(int k, int v) {
            key = k;
            val = v;
        }
    }
}
