class RangeModule {
    TreeSet<Range> ranges;

    public RangeModule() {
        this.ranges = new TreeSet<>();
    }
    
    public void addRange(int left, int right) {
        Iterator<Range> it = this.ranges.tailSet(new Range(0, left-1)).iterator();
        while (it.hasNext()) {
            Range r = it.next();
            if (right < r.left) break;
            left = Math.min(left, r.left);
            right = Math.max(right, r.right);
            it.remove();
        }
        this.ranges.add(new Range(left, right));
    }
    
    public boolean queryRange(int left, int right) {
        Range r = this.ranges.higher(new Range(0, left));
        return (r != null && r.left <= left && r.right >= right);
    }
    
    public void removeRange(int left, int right) {
        Iterator<Range> it = this.ranges.tailSet(new Range(0, left)).iterator();
        List<Range> toAdd = new ArrayList<>();
        while (it.hasNext()) {
            Range r = it.next();
            if (right < r.left) break;
            if (r.left < left) toAdd.add(new Range(r.left, left));
            if (r.right > right) toAdd.add(new Range(right, r.right));
            it.remove();
        }

        for (Range r : toAdd) this.ranges.add(r);
    }

    class Range implements Comparable<Range> {
        int left, right;
        public Range(int l, int r) {
            this.left = l;
            this.right = r;
        }

        [Override]
        public int compareTo(Range other) {
            if (this.right == other.right) return this.left - other.left;
            return this.right - other.right;
        }
    }
}

/**
 * Your RangeModule object will be instantiated and called as such:
 * RangeModule obj = new RangeModule();
 * obj.addRange(left,right);
 * boolean param_2 = obj.queryRange(left,right);
 * obj.removeRange(left,right);
 */
