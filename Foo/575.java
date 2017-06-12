public class Solution {
    public int distributeCandies(int[] candies) {
        int len = candies.length / 2;
        Set<Integer> kind = new HashSet<>();
        for (int i : candies) kind.add(i);

        return Math.min(len, kind.size());
    }
}