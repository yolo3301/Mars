public class NumArray {

    private int[] nums;
    private int[] tree;
    private int n;

    public NumArray(int[] nums) {
        this.nums = nums;
        this.n = nums.length;
        tree = new int[n+1];

        for (int i = 0; i < n; i++) {
            init(i, nums[i]);
        }
    }
    
    public void update(int i, int val) {
        int diff = val - nums[i];
        nums[i] = val;
        init(i, val);
    }
    
    public int sumRange(int i, int j) {
        return sum(j) - sum(i-1);
    }

    private void init(int i, int val) {
        i++;
        while (i <= n) {
            tree[i] += val;
            i += (i & -i);
        }
    }

    private int sum(int i) {
        int res = 0;
        while (i > 0) {
            res += tree[i];
            i -= (i & -i);
        }

        return res;
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(i,val);
 * int param_2 = obj.sumRange(i,j);
 */