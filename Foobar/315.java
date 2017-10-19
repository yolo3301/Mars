class Solution {
    public List<Integer> countSmaller(int[] nums) {
        if (nums.length == 0) return new ArrayList<>();

        Integer[] ret = new Integer[nums.length];
        ret[nums.length-1] = 0;

        TNode root = new TNode(nums[nums.length-1]);
        for (int i = nums.length-2; i >= 0; i--) {
            updateTree(root, i, nums[i], 0, ret);
        }

        return Arrays.asList(ret);
    }

    private void updateTree(TNode node, int index, int val, int sum, Integer[] ret) {
        if (val == node.val) {
            node.dup++;
            ret[index] = sum + node.leftSubTreeCnt;
            return;
        }

        if (val < node.val) {
            node.leftSubTreeCnt++;
            if (node.left == null) {
                TNode l = new TNode(val);
                node.left = l;
                ret[index] = sum;
            } else {
                updateTree(node.left, index, val, sum, ret);
            }
        } else {
            if (node.right == null) {
                TNode r = new TNode(val);
                node.right = r;
                ret[index] = sum + node.leftSubTreeCnt + node.dup;
            } else {
                updateTree(node.right, index, val, sum + node.leftSubTreeCnt + node.dup, ret);
            }
        }
    }

    class TNode {
        public TNode left, right;
        public int val, dup, leftSubTreeCnt;
        public TNode(int v) {
            val = v;
            leftSubTreeCnt = 0;
            dup = 1;
        }
    }
}
