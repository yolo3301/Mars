public class Solution {
    public int findPairs(int[] nums, int k) {
        if (k < 0) return 0;
        Map<Integer, Boolean> minus = new HashMap<>();
        Map<Integer, Boolean> add = new HashMap<>();
        int res = 0;
        for (int i : nums) {
            if ((!minus.containsKey(i) || k == 0) && minus.containsKey(i-k) && minus.get(i-k) == false) {
                res++;
                minus.put(i-k, true);
            }
            if (!add.containsKey(i) && add.containsKey(i+k) && add.get(i+k) == false && k != 0) {
                res++;
                add.put(i+k, true);
            }
            if (!add.containsKey(i))
                add.put(i, false);
            if (!minus.containsKey(i))
                minus.put(i, false);
        }

        return res;
    }
}

public class Solution {
    public int findPairs(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k < 0)   return 0;
        
        Map<Integer, Integer> map = new HashMap<>();
        int count = 0;
        for (int i : nums) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (k == 0) {
                //count how many elements in the array that appear more than twice.
                if (entry.getValue() >= 2) {
                    count++;
                } 
            } else {
                if (map.containsKey(entry.getKey() + k)) {
                    count++;
                }
            }
        }
        
        return count;
    }
}