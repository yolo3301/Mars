class Solution {
    public boolean verifyPreorder(int[] preorder) {
        return tryCreate(preorder, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    int index = 0;

    private boolean tryCreate(int[] preorder, int min, int max) {
        if (index >= preorder.length) return true;

        int curr = preorder[index];
        if (min < curr && curr < max) {
            index++;
            return tryCreate(preorder, min, curr) && tryCreate(preorder, curr, max);
        } else if (curr >= max) {
            return true;
        }

        return false;
    }
}