class KthLargest {
    private PriorityQueue<Integer> q;
    private int k;

    public KthLargest(int k, int[] nums) {
        this.q = new PriorityQueue<>();
        this.k = k;
        for (int i = 0; i < nums.length; i++)
            this.add(nums[i]);
    }
    
    public int add(int val) {
        q.add(val);
        if (q.size() > k) q.remove();
        return q.peek();
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */