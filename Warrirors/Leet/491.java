public class Solution {
    public List<List<Integer>> findSubsequences(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        helper(res, new ArrayList<Integer>(), nums, 0);
        return res;
    }

    private void helper(List<List<Integer>> res, List<Integer> list, int[] nums, int id) {
        if (list.size() > 1) res.add(new ArrayList<Integer>(list));
        List<Integer> unique = new ArrayList<Integer>();
        for (int i = id; i < nums.length; i++) {
            if (id > 0 && nums[i] < nums[id-1]) continue; // skip non-increase
            if (unique.contains(nums[i])) continue; // skip duplicate
            unique.add(nums[i]);
            list.add(nums[i]);
            helper(res, list, nums, i+1);
            list.remove(list.size()-1);
        }
    }
}

public class Solution {
    public List<List<Integer>> findSubsequences(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums.length == 0) return res;

        // Record the index of last appreance
        Map<Integer, Integer> index = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            index.put(nums[i], i);
        }

        List<List<Integer>>[] memo = new ArrayList[nums.length];

        for (int i = 1; i < nums.length; i++) {
            memo[i] = new ArrayList<>();
            Set<Integer> met = new HashSet<>();
            for (int j = i - 1; j >= 0; j--) {
                // Use hashset to remove duplicates
                if (met.contains(nums[j])) continue;
                if (nums[j] <= nums[i]) {
                    List<Integer> two = new ArrayList<>();
                    two.add(nums[j]);
                    two.add(nums[i]);
                    memo[i].add(two);

                    if (memo[j] != null) {
                        for (List<Integer> prev : memo[j]) {
                            List<Integer> curr = new ArrayList<>(prev);
                            curr.add(nums[i]);
                            memo[i].add(curr);
                        }
                    }
                }
                met.add(nums[j]);
            }

            // Only add the sequence to the final result if this is the last appreance
            if (i == index.get(nums[i])) {
                res.addAll(memo[i]);
            }
        }

        return res;
    }
}