public class Solution {
    public int maxDistance(List<List<Integer>> arrays) {
        int min1 = Integer.MAX_VALUE, min2 = Integer.MAX_VALUE;
        for (int i = 0; i < arrays.size(); i++) {
            int curr = arrays.get(i).get(0);
            if (curr < min1) {
                min2 = min1;
                min1 = curr;
            } else if (curr < min2) {
                min2 = curr;
            }
        }

        int res = 0;
        for (int i = 0; i < arrays.size(); i++) {
            int currMax = arrays.get(i).get(arrays.get(i).size() - 1);
            int currMin = arrays.get(i).get(0);
            if (currMin != min1) {
                res = Math.max(res, Math.abs(currMax - min1));
            } else {
                res = Math.max(res, Math.abs(currMax - min2));
            }
        }

        return res;
    }
}