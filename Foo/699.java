class Solution {
    public List<Integer> fallingSquares(int[][] positions) {
        int lm = Integer.MAX_VALUE, rm = Integer.MIN_VALUE;
        for (int[] pos : positions) {
            lm = Math.min(lm, pos[0]);
            rm = Math.max(rm, pos[0]+pos[1]-1);
        }

        LazySigTree tree = new LazySigTree(rm - lm + 1);
        int norm = lm;

        List<Integer> ret = new ArrayList<>();
        int high = 0;
        for (int[] pos : positions) {
            int l = pos[0] - norm;
            int r = pos[0] + pos[1] - 1 - norm;
            int h = tree.rangeMax(l, r) + pos[1];
            tree.update(l, r, h);
            high = Math.max(high, h);
            ret.add(high);
        }

        return ret;
    }

    class LazySigTree {
        private int len;
        private SigNode root, lazyRoot;

        public LazySigTree(int len) {
            this.len = len;
            this.root = construct(0, len-1);
            this.lazyRoot = construct(0, len-1);
        }

        public void update(int i, int j, int val) {
            updateInternal(i, j, root, lazyRoot, val);
        }

        private int rangeMax(int i, int j) {
            return rangeMaxInternal(i, j, root, lazyRoot);
        }

        private int rangeMaxInternal(int i, int j, SigNode node, SigNode lazy) {
            if (node == null || i > node.end || j < node.start)
                return 0;

            if (lazy.val != 0) {
                node.val = Math.max(node.val, lazy.val);
                if (lazy.left != null) lazy.left.val = lazy.val;
                if (lazy.right != null) lazy.right.val = lazy.val;
                lazy.val = 0;
            }

            if (i <= node.start && node.end <= j) {
                return node.val;
            }

            return Math.max(rangeMaxInternal(i, j, node.left, lazy.left),
                rangeMaxInternal(i, j, node.right, lazy.right));
        }

        private void updateInternal(int i, int j, SigNode node, SigNode lazy, int val) {
            if (node == null) return;

            if (lazy.val != 0) {
                node.val = Math.max(node.val, lazy.val);
                if (lazy.left != null) lazy.left.val = lazy.val;
                if (lazy.right != null) lazy.right.val = lazy.val;
                lazy.val = 0;
            }

            if (node.start > j || node.end < i)
                return;

            if (i <= node.start && node.end <= j) {
                node.val = Math.max(node.val, val);

                if (lazy.left != null) lazy.left.val = Math.max(lazy.left.val, node.val);
                if (lazy.right != null) lazy.right.val = Math.max(lazy.right.val, node.val);

                return;
            }

            updateInternal(i, j, node.left, lazy.left, val);
            updateInternal(i, j, node.right, lazy.right, val);
            
            if (node.left != null) {
                node.val = Math.max(node.val, node.left.val);
            }
            
            if (node.right != null) {
                node.val = Math.max(node.val, node.right.val);
            }
        }

        private SigNode construct(int l, int r) {
            if (l > r) return null;
            if (l == r) return new SigNode(l, r);

            int m = l + (r - l) / 2;
            SigNode cur = new SigNode(l, r);
            cur.left = construct(l, m);
            cur.right = construct(m+1, r);

            return cur;
        }
    }

    class SigNode {
        public SigNode left, right;
        public int val = 0, start, end;
        public SigNode(int s, int e) {
            start = s;
            end = e;
        }
    }
}



class Solution {
    private class Interval {
        int start, end, height;
        public Interval(int start, int end, int height) {
            this.start = start;
            this.end = end;
            this.height = height;
        }
    }
    public List<Integer> fallingSquares(int[][] positions) {
        List<Interval> intervals = new ArrayList<>();
        List<Integer> res = new ArrayList<>();
        int h = 0;
        for (int[] pos : positions) {
            Interval cur = new Interval(pos[0], pos[0] + pos[1] - 1, pos[1]);
            h = Math.max(h, getHeight(intervals, cur));
            res.add(h);
        }
        return res;
    }
    private int getHeight(List<Interval> intervals, Interval cur) {
        int preMaxHeight = 0;
        for (Interval i : intervals) {
            // Interval i does not intersect with cur
            if (i.end < cur.start) continue;
            if (i.start > cur.end) continue;
            // find the max height beneath cur
            preMaxHeight = Math.max(preMaxHeight, i.height);
        }
        cur.height += preMaxHeight;
        intervals.add(cur);
        return cur.height;
    }
}
