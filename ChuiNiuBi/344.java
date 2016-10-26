/**
 *  344. Reverse String
 *
 *  Write a function that takes a string as input and returns the string reversed.
 *  Example: Given s = "hello", return "olleh"
 *
 */

public class Solution {
    public String reverseString(String s) {
        if (s == null || s.length() < 2)
            return s;
        
        int l = 0, r = s.length() - 1;
        char[] arr = s.toCharArray();
        while (l < r) {
            char tmp = arr[l];
            arr[l] = arr[r];
            arr[r] = tmp;
            l++;
            r--;
        }
        
        return new String(arr);
    }
}