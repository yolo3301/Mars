public class AllOne {

    public class Node {
        public Node next;
        public Node prev;
        public int value;
        public Set<String> keys;
        public Node(int v) {
            value = v;
            keys = new HashSet<>();
            next = null;
            prev = null;
        }
    }

    private Map<String, Node> map;
    private Node head;
    private Node tail;

    /** Initialize your data structure here. */
    public AllOne() {
        map = new HashMap<>();
        head = null;
        tail = null;
    }

    /** Inserts a new key <Key> with value 1. Or increments an existing key by 1. */
    public void inc(String key) {
        if (map.containsKey(key)) {
            Node node = map.get(key);
            node.keys.remove(key);

            if (node.next != null) {
                if (node.next.value == node.value + 1) {
                    node.next.keys.add(key);
                    map.put(key, node.next);
                } else {
                    Node nt = new Node(node.value + 1);
                    nt.keys.add(key);
                    nt.next = node.next;
                    nt.prev = node;
                    node.next = nt;
                    nt.next.prev = nt;
                    map.put(key, nt);
                }
            } else {
                Node nt = new Node(node.value + 1);
                nt.keys.add(key);
                nt.prev = node;
                node.next = nt;
                tail = nt;
                map.put(key, tail);
            }

            if (node.keys.isEmpty()) {
                if (head != node) {
                    node.prev.next = node.next;
                    node.next.prev = node.prev;
                } else {
                    head = node.next;
                    head.prev = null;
                }
            }
        } else {
            if (head == null) {
                Node nt = new Node(1);
                nt.keys.add(key);
                head = nt;
                tail = nt;
            } else {
                if (head.value == 1) {
                    head.keys.add(key);
                } else {
                    Node nt = new Node(1);
                    nt.keys.add(key);
                    nt.next = head;
                    head.prev = nt;
                    head = nt;
                }
            }
            map.put(key, head);
        }
    }

    /** Decrements an existing key by 1. If Key's value is 1, remove it from the data structure. */
    public void dec(String key) {
        if (!map.containsKey(key)) return;

        Node node = map.get(key);
        map.remove(key);
        node.keys.remove(key);

        if (node.value > 1) {
            if (node.prev != null) {
                if (node.prev.value == node.value - 1) {
                    node.prev.keys.add(key);
                    map.put(key, node.prev);
                } else {
                    Node nt = new Node(node.value - 1);
                    nt.keys.add(key);
                    nt.prev = node.prev;
                    nt.next = node;
                    node.prev = nt;
                    nt.prev.next = nt;
                    map.put(key, nt);
                }
            } else {
                Node nt = new Node(node.value - 1);
                nt.keys.add(key);
                node.prev = nt;
                nt.next = node;
                head = nt;
                map.put(key, nt);
            }
        }

        if (node.keys.isEmpty()) {
            if (tail == node) {
                if (head == node) {
                    head = null;
                    tail = null;
                } else {
                    node.prev.next = null;
                    tail = node.prev;
                }
            } else {
                node.next.prev = node.prev;
                if (node.prev != null) {
                    node.prev.next = node.next;
                } else {
                    head = node.next;
                }
            }
        }
    }
    
    private void printNode(String m) {
        Node p = head;
        StringBuilder sb = new StringBuilder();
        while (p != null) {
            sb.append(p.value).append('=').append(p.keys).append("; ");
            p = p.next;
        }
        System.out.println("In " + m);
        System.out.println(sb.toString());
    }

    /** Returns one of the keys with maximal value. */
    public String getMaxKey() {
        if (tail == null) return "";
        return tail.keys.iterator().next();
    }

    /** Returns one of the keys with Minimal value. */
    public String getMinKey() {
        if (head == null) return "";
        return head.keys.iterator().next();
    }
}
