// https://discuss.leetcode.com/topic/49741/easy-understood-java-dp-solution-in-28ms-with-o-n-2-time/8
public class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        List<Integer> res = new ArrayList<>();
        if (nums.length == 0) return res;
        Arrays.sort(nums);

        int[] size = new int[nums.length];
        size[0] = 1;

        for (int i = 1; i < nums.length; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (nums[i] % nums[j] == 0)
                    size[i] = Math.max(size[i], size[j] + 1);
            }
        }

        int maxSizeIndex = 0;
        for (int i = 0; i < nums.length; i++) {
            if (size[i] > size[maxSizeIndex]) {
                maxSizeIndex = i;
            }
        }

        int curr = nums[maxSizeIndex];
        int currSize = size[maxSizeIndex];

        for (int i = maxSizeIndex; i >= 0; i--) {
            if (curr % nums[i] == 0 && size[i] == currSize) {
                res.add(nums[i]);
                curr = nums[i];
                currSize--;
            }
        }

        return res;
    }
}
