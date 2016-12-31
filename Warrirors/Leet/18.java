// Another way is to convert to 3sum
public class Solution {
    public class Entry {
        public int val;
        public int index1;
        public int index2;

        public Entry(int val, int i1, int i2) {
            this.val = val;
            this.index1 = i1;
            this.index2 = i2;
        }

        public boolean nooverlap(Entry other) {
            return index1 != other.index1 && index1 != other.index2 && index2 != other.index1 && index2 != other.index2;
        }
    }

    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<Entry> sum2 = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                sum2.add(new Entry(nums[i] + nums[j], i, j));
            }
        }

        Set<List<Integer>> res = new HashSet<>();
        Map<Integer, List<Entry>> map = new HashMap<>();
        for (Entry e : sum2) {
            if (map.containsKey(e.val)) {
                for (Entry o : map.get(e.val)) {
                    if (e.nooverlap(o)) {
                        int v1 = nums[e.index1];
                        int v2 = nums[e.index2];
                        int v3 = nums[o.index1];
                        int v4 = nums[o.index2];
                        Integer[] arr = new Integer[] {v1, v2, v3, v4};
                        Arrays.sort(arr);
                        res.add(Arrays.asList(arr));
                    }
                }
            }

            if (!map.containsKey(target - e.val)) {
                map.put(target - e.val, new ArrayList<>());
            }
            map.get(target - e.val).add(e);
        }

        return new ArrayList<>(res);
    }
}
