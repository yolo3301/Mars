public class NumArray {

    public class Node {
        public int sum;
        public int start;
        public int end;
        public Node left;
        public Node right;
        public Node(int s, int e) {
            start = s;
            end = e;
            sum = 0;
            left = null;
            right = null;
        }
    }

    private Node root;
    private int len;

    public NumArray(int[] nums) {
        len = nums.length;
        root = buildTree(nums, 0, len - 1);
    }
    
    public void update(int i, int val) {
        updateTree(root, i, val, 0, len - 1);
    }
    
    public int sumRange(int i, int j) {
        return sumRange(root, i, j, 0, len - 1);
    }

    private int sumRange(Node n, int i, int j, int s, int e) {
        if (n == null || j < s || i > e) return 0;

        if (i == s && j == e) return n.sum;

        int m = s + (e - s) / 2;
        if (j <= m) return sumRange(n.left, i, j, s, m);
        else if (i > m) return sumRange(n.right, i, j, m+1, e);
        else return sumRange(n.left, i, m, s, m) + sumRange(n.right, m+1, j, m+1, e);
    }

    private void updateTree(Node n, int i, int val, int s, int e) {
        if (n == null || i < s || i > e) return;

        if (s == i && e == i) {
            n.sum = val;
            return;
        }

        int m = s + (e - s) / 2;
        if (i <= m) updateTree(n.left, i, val, s, m);
        else updateTree(n.right, i, val, m+1, e);

        n.sum = 0;
        if (n.left != null) n.sum += n.left.sum;
        if (n.right != null) n.sum += n.right.sum;
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

        if (l != null) n.sum += l.sum;
        if (r != null) n.sum += r.sum;
        n.left = l;
        n.right = r;
        return n;
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(i,val);
 * int param_2 = obj.sumRange(i,j);
 */