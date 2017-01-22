public class Solution {
    public int findRadius(int[] houses, int[] heaters) {
        Arrays.sort(houses);
        Arrays.sort(heaters);
        int res = 0;
        int j = 0;
        for (int i = 0; i < houses.length; i++) {
            while (j < heaters.length && heaters[j] < houses[i]) j++;

            int dist1 = (j == 0) ? Integer.MAX_VALUE : Math.abs(houses[i] - heaters[j-1]);
            if (dist1 <= res) continue;
            int dist2 = (j >= heaters.length) ? Integer.MAX_VALUE : Math.abs(houses[i] - heaters[j]);
            if (dist2 <= res) continue;

            res = Math.min(dist1, dist2);
        }

        return res;
    }
}
