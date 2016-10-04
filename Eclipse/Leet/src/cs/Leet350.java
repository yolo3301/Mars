package cs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Leet350 {
    public int[] intersect(int[] nums1, int[] nums2) {
        if (nums1 == null || nums2 == null) return null;

        if (nums1.length > nums2.length) {
            return generate(nums1, count(nums2), nums2.length);
        } else {
            return generate(nums2, count(nums1), nums1.length);
        }
    }

    private Map<Integer, Integer> count(int[] nums) {
        Map<Integer, Integer> res = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (res.containsKey(nums[i])) {
                res.put(nums[i], res.get(nums[i]) + 1);
            } else {
                res.put(nums[i], 1);
            }
        }

        return res;
    }

    private int[] generate(int[] nums, Map<Integer, Integer> count, int total) {
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (count.containsKey(nums[i]) && count.get(nums[i]) > 0) {
                res.add(nums[i]);
                count.put(nums[i], count.get(nums[i]) - 1);
                if (--total == 0) {
                    break;
                }
            }
        }

        return res.stream().mapToInt(Integer::intValue).toArray();
    }
}
