// O(nlogn)
class Solution {
    public int kEmptySlots(int[] flowers, int k) {
        TreeSet<Integer> bst = new TreeSet<>();
        for (int i = 0; i < flowers.length; i++) {
            int x = flowers[i];
            Integer left = bst.floor(x);
            Integer right = bst.ceiling(x);
            if (left != null && x - left.intValue() - 1 == k) {
                return i+1;
            }
            if (right != null && right.intValue() - x - 1 == k) {
                return i+1;
            }
            bst.add(x);
        }
        return -1;
    }
}

class Solution {
    public int kEmptySlots(int[] flowers, int k) {
        int[] days = new int[flowers.length];
        for (int i = 0; i < flowers.length; i++) {
            days[flowers[i]-1] = i+1;
        }

        int left = 0, right = k+1, res = Integer.MAX_VALUE;
        for (int i = 0; right < flowers.length; i++) {
            if (days[i] < days[left] || days[i] <= days[right]) {
                if (i == right)
                    res = Math.min(res, Math.max(days[left], days[right]));
                left = i;
                right = i+k+1;
            }
        }

        return (res == Integer.MAX_VALUE) ? -1 : res;
    }
}
