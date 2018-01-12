class Solution {
    public int reachNumber(int target) {
        target = Math.abs(target);
        int sum = 0, k = 0;
        while (sum < target) {
            sum += ++k;
        }

        if (sum == target) return k;
        if ((sum - target) % 2 == 0) return k;
        return k + ((k % 2 == 0) ? 1 : 2);
    }
}

