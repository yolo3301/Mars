public class Solution {
    public boolean verifyPreorder(int[] preorder) {
        return tryCreate(preorder, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    // just like pre order traverse
    int index = 0;
    private boolean tryCreate(int[] seq, int min, int max) {
        if (index >= seq.length) return true;
        int curr = seq[index++];
        // System.out.println(curr + " min:" + min + " max:" + max);
        if (curr < min) return false; // the only case that is invalid
        if (curr < max) { // the current value is between min and max
            boolean flag = tryCreate(seq, min, curr); // go left
            flag &= tryCreate(seq, curr, max); // go right
            return flag;
        } else { // if greater than max, then the current value should be in the parent's right sub tree
            index--; // IMPORTANT! -- to keep the current value
            return true;
        }
    }
}