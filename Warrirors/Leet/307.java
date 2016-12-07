public class NumArray {

    public class Node {
        public int sum;
        public int start;
        public int end;
        public Node left;
        public Node right;
        public Node(int s, int e) {
            sum = 0;
            start = s;
            end = e;
            left = null;
            right = null;
        }
    }

    private Node root;
    private int len;

    public NumArray(int[] nums) {
        root = buildTree(nums, 0, nums.length - 1);
        len = nums.length;
    }

    void update(int i, int val) {
        updateTree(root, i, val, 0, len - 1);
    }

    public int sumRange(int i, int j) {
        return sumRange(root, i, j);
    }

    private int sumRange(Node node, int i, int j) {
        if (node.start == i && node.end == j) return node.sum;

        if (j <= node.left.end) {
            return sumRange(node.left, i, j);
        } else if (i >= node.right.start) {
            return sumRange(node.right, i, j);
        } else {
            return sumRange(node.left, i, node.left.end) + sumRange(node.right, node.right.start, j);
        }
    }

    private void updateTree(Node node, int i, int val, int s, int e) {
        if (node == null) return;

        if (i < node.start || i > node.end) return;

        if (i == node.start && i == node.end) {
            node.sum = val;
            return;
        }

        int m = s + (e - s) / 2;
        if (i >= s && i <= m) {
            updateTree(node.left, i, val, s, m);
        } else {
            updateTree(node.right, i, val, m+1, e);
        }

        node.sum = 0;
        if (node.left != null) node.sum += node.left.sum;
        if (node.right != null) node.sum += node.right.sum;
    }

    private Node buildTree(int[] nums, int s, int e) {
        if (s > e) return null;

        Node curr = new Node(s, e);
        if (s == e) {
            curr.sum = nums[s];
            return curr;
        }

        int m = s + (e - s) / 2;

        curr.left = buildTree(nums, s, m);
        curr.right = buildTree(nums, m+1, e);

        if (curr.left != null) curr.sum += curr.left.sum;
        if (curr.right != null) curr.sum += curr.right.sum;

        return curr;
    }
}


// Your NumArray object will be instantiated and called as such:
// NumArray numArray = new NumArray(nums);
// numArray.sumRange(0, 1);
// numArray.update(1, 10);
// numArray.sumRange(1, 2);
