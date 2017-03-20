public class Solution {
    public class Node {
        public Node left;
        public Node right;
        public int dup;
        public int count;
        public int val;
        public Node(int v) {
            val = v;
            count = 0;
            dup = 1;
        }
    }

    public List<Integer> countSmaller(int[] nums) {
        if (nums.length == 0) return new ArrayList<>();
        Integer[] res = new Integer[nums.length];
        res[nums.length - 1] = 0;
        Node root = new Node(nums[nums.length - 1]);
        for (int i = nums.length - 2; i >= 0; i--) {
            insert(root, i, nums[i], 0, res);
        }

        return Arrays.asList(res);
    }

    private void insert(Node node, int index, int val, int sum, Integer[] res) {
        if (node.val == val) {
            node.dup++;
            res[index] = sum + node.count;
            return;
        }

        if (val < node.val) {
            node.count++;
            if (node.left == null) {
                Node l = new Node(val);
                res[index] = sum;
                node.left = l;
            } else {
                insert(node.left, index, val, sum, res);
            }
        } else {
            if (node.right == null) {
                Node r = new Node(val);
                res[index] = sum + node.count + node.dup;
                node.right = r;
            } else {
                insert(node.right, index, val, sum + node.count + node.dup, res);
            }
        }
    }
}