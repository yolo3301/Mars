public class Solution {
    public List<Integer> countSmaller(int[] nums) {
        Integer[] res = new Integer[nums.length];
        if (nums.length == 0) return new ArrayList<>();

        MyBst bst = new MyBst();
        for (int i = nums.length - 1; i >= 0; i--) {
            res[i] = bst.getCnt(nums[i]);
            bst.insert(nums[i]);
        }

        return Arrays.asList(res);
    }

    public class Node {
        public Node left, right;
        public int key, cnt, rep;
        public Node(int k) {
            key = k;
            cnt = 0;
            rep = 1;
        }
    }

    public class MyBst {
        public Node root;
        public void insert(int key) {
            if (root == null) {
                root = new Node(key);
                return;
            }

            insert(root, key);
        }

        private Node insert(Node node, int key) {
            if (node == null) {
                Node curr = new Node(key);
                return curr;
            }

            if (node.key == key) {
                node.rep++;
                return node;
            } else if (node.key > key) {
                node.cnt++;
                node.left = insert(node.left, key);
            } else {
                node.right = insert(node.right, key);
            }

            return node;
        }

        public int getCnt(int key) {
            return getCnt(root, key);
        }

        private int getCnt(Node node, int key) {
            if (node == null) return 0;
            if (node.key == key) return node.cnt;

            if (node.key < key) {
                return node.cnt + node.rep + getCnt(node.right, key);
            } else {
                return getCnt(node.left, key);
            }
        }
    }
}