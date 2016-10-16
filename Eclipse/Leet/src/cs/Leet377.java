package cs;

import java.util.Arrays;

public class Leet377 {
	public int combinationSum4(int[] nums, int target) {
        if (target <= 0 || nums.length == 0) return 0;

        Arrays.sort(nums);
        int[] mem = new int[target + 1];
        mem[0] = 0;

        for (int i = 1; i <= target; i++) {
            for (int j = 0; j < nums.length && nums[j] <= i; j++) {
                if (nums[j] == i) {
                    mem[i]++;
                }
                mem[i] += mem[i - nums[j]];
            }
        }

        return mem[target];
    }
}
