/*
Why this works?
Let's say we have [a1, b1]
Swap a1 or b1 are the SAME! Why?
If swap a1 can save 1 swap, then it means there is somewhere down the road has [a2, b2]
Then swap b1 will do the same
*/
class Solution {
    public int minSwapsCouples(int[] row) {
        int[] index = new int[row.length];
        for (int i = 0; i < row.length; i++) index[row[i]] = i;

        int ret = 0;
        for (int i = 0; i < row.length; i += 2) {
            int other = (row[i] % 2 == 0) ? row[i]+1 : row[i]-1;
            if (other != row[i+1]) {
                swap(row[i+1], other, row, index);
                ret++;
            }
        }
        return ret;
    }

    private void swap(int v1, int v2, int[] row, int[] index) {
        int i1 = index[v1];
        int i2 = index[v2];

        int tmp = row[i1];
        row[i1] = row[i2];
        row[i2] = tmp;

        index[v1] = i2;
        index[v2] = i1;
    }
}