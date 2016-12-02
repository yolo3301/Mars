/*
Intersection of Two Arrays

Given two arrays, write a function to compute their intersection.

Example:
Given nums1 = [1, 2, 2, 1], nums2 = [2, 2], return [2].
*/

public class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        if (nums1 == null || nums2 == null)
            return null;
            
        HashSet<Integer> set = new HashSet<Integer>();
        HashSet<Integer> res = new HashSet<Integer>();
        for (int num : nums1) {
            set.add(num);
        }
        
        for (int num : nums2) {
            if (set.contains(num))
                res.add(num);
        }
        
        int[] arr = new int[res.size()];
        int i = 0;
        for (int key : res) {
            arr[i++] = key;
        }
        return arr;
    }
}