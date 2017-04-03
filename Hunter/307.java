public class NumArray {

    public class Node {
        int start, end, sum;
        Node left, right;
        public Node(int s, int e) {
            start = s;
            end = e;
            sum = 0;
        }
    }

    private Node root;

    public NumArray(int[] nums) {
        root = buildTree(nums, 0, nums.length-1);
    }
    
    public void update(int i, int val) {
        update(root, i, val);
    }
    
    public int sumRange(int i, int j) {
        return range(root, i, j);
    }

    private int range(Node node, int i, int j) {
        if (i == node.start && j == node.end) return node.sum;
        int m = node.start + (node.end - node.start) / 2;
        if (j <= m) return range(node.left, i, j);
        else if (i > m) return range(node.right, i, j);
        else return range(node.left, i, m)+range(node.right, m+1, j);
    }

    private void update(Node node, int index, int target) {
        if (index < node.start || index > node.end) return;

        if (node.start == node.end && node.start == index) {
            node.sum = target;
            return;
        }
        
        int m = node.start + (node.end - node.start) / 2;
        if (index <= m) update(node.left, index, target);
        else update(node.right, index, target);

        node.sum = 0;
        if (node.left != null) node.sum += node.left.sum;
        if (node.right != null) node.sum += node.right.sum;
    }

    private Node buildTree(int[] nums, int s, int e) {
        if (s > e) return null;

        Node n = new Node(s, e);

        if (s == e) {
            n.sum = nums[s];
            return n;
        }

        int m = s + (e - s) / 2;
        Node l = buildTree(nums, s, m);
        Node r = buildTree(nums, m+1, e);
        n.left = l;
        n.right = r;

        if (l != null) n.sum += l.sum;
        if (r != null) n.sum += r.sum;

        return n;
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(i,val);
 * int param_2 = obj.sumRange(i,j);
 */