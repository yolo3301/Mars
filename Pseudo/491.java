public class Solution {
    public List<List<Integer>> findSubsequences(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums.length < 2) return res;

        Map<Integer, Integer> lastIndex = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            lastIndex.put(nums[i], i);
        }

        List<List<Integer>>[] prev = new ArrayList[nums.length];
        for (int i = 0; i < nums.length; i++) {
            prev[i] = new ArrayList<>();
            Set<Integer> seen = new HashSet<>();
            for (int j = i-1; j >= 0; j--) {
                if (!seen.contains(nums[j]) && nums[j] <= nums[i]) {
                    seen.add(nums[j]);
                    prev[i].add(Arrays.asList(nums[j], nums[i]));
                    for (List<Integer> l : prev[j]) {
                        List<Integer> c = new ArrayList<>(l);
                        c.add(nums[i]);
                        prev[i].add(c);
                    }
                }
            }

            if (i == lastIndex.get(nums[i])) {
                res.addAll(prev[i]);
            }
        }

        return res;
    }
}