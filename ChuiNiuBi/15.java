/*
3 sum
*/

public class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList();
        if (nums == null || nums.length < 3)
            return res;
        
        Arrays.sort(nums);
        int n = nums.length;
        for (int i = 0; i < n-2; i++) {
            if (i != 0 && nums[i-1] == nums[i])
                continue;
            
            int j = i+1;
            int k = n-1;
            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];
                if (sum == 0) {
                    List<Integer> list = new ArrayList<Integer>();
                    list.add(nums[i]);
                    list.add(nums[j]);
                    list.add(nums[k]);
                    if (!res.contains(list))
                        res.add(list);
                    j++;
                    while (j < k && nums[j-1] == nums[j])   j++;
                    k--;
                    while (j < k && nums[k+1] == nums[k])   k--;
                } else if (sum < 0) {
                    j++;
                } else {
                    k--;
                }
            }
        }
        
        return res;
    }
}