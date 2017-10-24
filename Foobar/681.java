class Solution {
    public int kEmptySlots(int[] flowers, int k) {
        // reverse index
        int[] days = new int[flowers.length];
        for (int i = 0; i < flowers.length; i++) {
            days[flowers[i]-1] = i+1;
        }

        // keep a k-ish window
        int left = 0, right = k+1, ret = Integer.MAX_VALUE;
        for (int i = 0; right < days.length; i++) {
            /*
            1. What does days[i] < days[left] or days[right] mean?
                it means some floor between left & right bloomed early than them
            2. Why it's <= days[right]?
                to handle == case
            3. Why it's ok to set left to i when condition meets?
                because previous ones are for sure greater than the current one
                which means the current floor will not work for previous ones
            */
            if (days[i] < days[left] || days[i] <= days[right]) {
                if (days[i] == days[right]) {
                    // Find a candidate
                    ret = Math.min(ret, Math.max(days[left], days[right]));
                }

                left = i;
                right = i+k+1;
            }
        }

        return ret== Integer.MAX_VALUE ? -1 : ret;
    }
}
