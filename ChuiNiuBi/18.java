/*
4sum
*/

public class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList();
        if (nums == null || nums.length < 4)
            return res;
            
        int n = nums.length;
        Arrays.sort(nums);
        for (int i = 0; i < n-3; i++) {
            if (i != 0 && nums[i] == nums[i-1]) continue;
            
            for (int j = i+1; j < n-2; j++) {
                if (j != i+1 && nums[j] == nums[j-1])   continue;
                
                int l = j+1;
                int r = n-1;
                while (l < r) {
                    int sum = nums[i] + nums[j] + nums[l] + nums[r];
                    if (sum == target) {
                        List<Integer> list = new ArrayList<Integer>();
                        list.add(nums[i]);
                        list.add(nums[j]);
                        list.add(nums[l]);
                        list.add(nums[r]);
                        if (!res.contains(list))
                            res.add(list);
                        l++;
                        while (l < r && nums[l-1] == nums[l])   l++;
                        r--;
                        while (l  <r && nums[r] == nums[r+1])   r--;
                    } else if (sum < target) {
                        l++;
                    } else {
                        r--;
                    }
                }
            }
        }
        
        return res;
    }
}