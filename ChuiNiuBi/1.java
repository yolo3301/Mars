/*
Two Sum

*/

public class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] res = new int[2];
        
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            int a1 = nums[i];
            if (map.containsKey(a1)) {
                res[0] = map.get(a1);
                res[1] = i;
                break;
            }
            map.put(target - a1, i);
        }
        
        return res;
    }
}