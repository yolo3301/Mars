package cs;

import java.util.Arrays;
import java.util.HashSet;

public class Leet349 {
    public int[] intersection(int[] nums1, int[] nums2) {
        if (nums1.length == 0 || nums2.length == 0) return new int[0];

        HashSet<Integer> set = new HashSet<>();
        HashSet<Integer> result = new HashSet<>();
        for (int i = 0; i < nums1.length; i++) {
            set.add(nums1[i]);
        }
        for (int j = 0; j < nums2.length; j++) {
            if (set.contains(nums2[j])) {
                result.add(nums2[j]);
            }
        }

        // Stream -> new in JDK 8
        return Arrays.stream(result.toArray(new Integer[0])).mapToInt(Integer::intValue).toArray();
    }
}
