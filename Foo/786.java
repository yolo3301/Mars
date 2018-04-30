class Solution {
    public int[] kthSmallestPrimeFraction(int[] A, int K) {
        PriorityQueue<Holder> q = new PriorityQueue<>((a, b) -> {
            if (a.val < b.val) return -1;
            else if (a.val > b.val) return 1;
            return 0;
        });

        for (int i = 1; i < A.length; i++) {
            q.add(new Holder(A[0]*1.0/A[i], i, 0));
        }

        for (int i = 0; i < K-1; i++) {
            Holder cur = q.remove();
            if (cur.index > cur.start + 1) {
                q.add(new Holder(A[cur.start+1]*1.0/A[cur.index], cur.index, cur.start+1));
            }
        }

        Holder ret = q.remove();
        return new int[] {A[ret.start], A[ret.index]};
    }

    class Holder {
        public double val;
        public int index;
        public int start;
        public Holder(double val, int index, int start) {
            this.val = val;
            this.index = index;
            this.start = start;
        }
    }
}